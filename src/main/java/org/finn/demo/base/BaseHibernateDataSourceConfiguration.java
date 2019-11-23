package org.finn.demo.base;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.orm.jpa.*;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Collections;
import java.util.Map;

/**
 * @author Finn Zhao
 * @version 2019-11-23
 */
public abstract class BaseHibernateDataSourceConfiguration extends BaseDataSourceConfiguration {

    protected BaseHibernateDataSourceConfiguration(ObjectProvider<PersistenceUnitManager> persistenceUnitManagerProvider
            , ObjectProvider<EntityManagerFactoryBuilderCustomizer> customizers) {
        super(persistenceUnitManagerProvider, customizers);
    }

    public abstract HibernateProperties hibernateProperties();

    /**
     * method can be override.
     *
     * @return customizer
     */
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer() {
        return hibernateProperties -> {
        };
    }

    protected HibernateProperties createHibernateProperties() {
        return new HibernateProperties();
    }

    /**
     * method can be override.
     *
     * @param vendorProperties the vendor properties to customize
     */
    @Override
    protected void customizeVendorProperties(Map<String, Object> vendorProperties) {
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        HibernatePropertiesCustomizer hibernatePropertiesCustomizer = hibernatePropertiesCustomizer();

        HibernateSettings hibernateSettings = new HibernateSettings();
        hibernateSettings.hibernatePropertiesCustomizers(Collections.singletonList(hibernatePropertiesCustomizer));

        HibernateProperties hibernateProperties = this.hibernateProperties();
        JpaProperties jpaProperties = this.jpaProperties();
        return hibernateProperties.determineHibernateProperties(jpaProperties.getProperties(), hibernateSettings);
    }

}
