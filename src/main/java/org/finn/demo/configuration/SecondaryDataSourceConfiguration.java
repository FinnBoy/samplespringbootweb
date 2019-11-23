package org.finn.demo.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.finn.demo.base.HibernateDataSourceConfigurationAdapter;
import org.finn.demo.base.IntegrationDataSourceProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @author Finn Zhao
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = SecondaryDataSourceConfiguration.ENTITY_MANAGER_FACTORY
        , transactionManagerRef = SecondaryDataSourceConfiguration.TRANSACTION_MANAGER
        , basePackages = {"org.finn.demo.repository.secondary"})
public class SecondaryDataSourceConfiguration extends HibernateDataSourceConfigurationAdapter {

    public SecondaryDataSourceConfiguration(
            ObjectProvider<PersistenceUnitManager> persistenceUnitManagerProvider
            , ObjectProvider<EntityManagerFactoryBuilderCustomizer> customizers) {
        super(persistenceUnitManagerProvider, customizers);
    }

    public static final String DATA_SOURCE = "dataSourceSecondary";

    public static final String ENTITY_MANAGER_FACTORY = "entityManagerFactorySecondary";

    public static final String TRANSACTION_MANAGER = "transactionManagerSecondary";

    @Override
    protected String[] baseEntityPackages() {
        return new String[]{"org.finn.demo.domain.secondary"};
    }

    @Bean("integrationPropertiesSecondary")
    @ConfigurationProperties("app.sql-database.secondary")
    public IntegrationDataSourceProperties integrationProperties() {
        return new IntegrationDataSourceProperties();
    }

    @Bean(DATA_SOURCE)
    @ConfigurationProperties("app.sql-database.secondary.data-source")
    public DataSource dataSource() {
        DataSourceProperties properties = this.dataSourceProperties();
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        return this.buildEntityManagerFactoryBean();
    }

    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager() {
        EntityManagerFactory factory = this.entityManagerFactory().getObject();
        return this.buildTransactionManager(factory);
    }
}
