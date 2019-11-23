package org.finn.demo.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.autoconfigure.domain.EntityScanPackages;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Finn Zhao
 */
public abstract class BaseDataSourceConfiguration implements BeanFactoryAware {

    private static final Logger log = LoggerFactory.getLogger(BaseDataSourceConfiguration.class);

    public static final String DATA_SOURCE_PREFIX = "dataSource";

    public static final String ENTITY_MANAGER_FACTORY_PREFIX = "entityManagerFactory";

    public static final String TRANSACTION_MANAGER_PREFIX = "transactionManager";

    final private PersistenceUnitManager persistenceUnitManager;

    final private ObjectProvider<EntityManagerFactoryBuilderCustomizer> customizers;

    private ConfigurableListableBeanFactory beanFactory;

    protected BaseDataSourceConfiguration(
            ObjectProvider<PersistenceUnitManager> persistenceUnitManagerProvider,
            ObjectProvider<EntityManagerFactoryBuilderCustomizer> customizers) {
        this.persistenceUnitManager = persistenceUnitManagerProvider.getIfAvailable();
        this.customizers = customizers;
    }

    public abstract DataSourceProperties dataSourceProperties();

    public abstract DataSource dataSource();

    public abstract JpaProperties jpaProperties();

    public abstract LocalContainerEntityManagerFactoryBean entityManagerFactory();

    public abstract PlatformTransactionManager transactionManager();

    protected abstract AbstractJpaVendorAdapter createJpaVendorAdapter();

    protected abstract Map<String, Object> getVendorProperties();

    protected abstract String[] baseEntityPackages();

    /**
     * Customize vendor properties before they are used. Allows for post processing.
     *
     * @param vendorProperties the vendor properties to customize
     */
    protected abstract void customizeVendorProperties(Map<String, Object> vendorProperties);

    protected PlatformTransactionManager buildTransactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    protected JpaProperties createJpaProperties() {
        return new JpaProperties();
    }

    protected DataSourceProperties createDataSourceProperties() {
        return new DataSourceProperties();
    }

    protected LocalContainerEntityManagerFactoryBean buildEntityManagerFactoryBean() {
        Map<String, Object> vendorProperties = getVendorProperties();
        customizeVendorProperties(vendorProperties);
        DataSource dataSource = this.dataSource();
        EntityManagerFactoryBuilder builder = entityManagerFactoryBuilder();
        return builder.dataSource(dataSource)
                .packages(getPackagesToScan())
                .properties(vendorProperties)
                .mappingResources(getMappingResources())
                .jta(isJta())
                .build();
    }

    protected EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        JpaVendorAdapter jpaVendorAdapter = jpaVendorAdapter();
        Map<String, String> properties = jpaProperties().getProperties();
        EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(jpaVendorAdapter,
                properties, this.persistenceUnitManager);
        this.customizers.orderedStream().forEach((customizer) -> customizer.customize(builder));
        return builder;
    }

    protected JpaVendorAdapter jpaVendorAdapter() {
        AbstractJpaVendorAdapter adapter = createJpaVendorAdapter();
        JpaProperties jpaProperties = jpaProperties();
        DataSource dataSource = dataSource();
        adapter.setShowSql(jpaProperties.isShowSql());
        adapter.setDatabase(jpaProperties.determineDatabase(dataSource));
        adapter.setDatabasePlatform(jpaProperties.getDatabasePlatform());
        adapter.setGenerateDdl(jpaProperties.isGenerateDdl());
        return adapter;
    }

    protected String[] getPackagesToScan() {
        String[] basePackages = this.baseEntityPackages();
        if (basePackages != null && basePackages.length != 0) {
            log.info(Arrays.asList(basePackages).toString());
            return basePackages;
        }
        List<String> packages = EntityScanPackages.get(this.beanFactory).getPackageNames();
        if (packages.isEmpty() && AutoConfigurationPackages.has(this.beanFactory)) {
            packages = AutoConfigurationPackages.get(this.beanFactory);
        }
        return StringUtils.toStringArray(packages);
    }

    protected String[] getMappingResources() {
        JpaProperties jpaProperties = jpaProperties();
        List<String> mappingResources = jpaProperties.getMappingResources();
        return (!ObjectUtils.isEmpty(mappingResources) ? StringUtils.toStringArray(mappingResources) : null);
    }

    protected boolean isJta() {
        return false;
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

}
