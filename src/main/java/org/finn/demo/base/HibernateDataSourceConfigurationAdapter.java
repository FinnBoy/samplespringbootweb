package org.finn.demo.base;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilderCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.orm.jpa.persistenceunit.PersistenceUnitManager;

/**
 * @author Finn Zhao
 * @version 2019-11-23
 */
public abstract class HibernateDataSourceConfigurationAdapter extends BaseHibernateDataSourceConfiguration {

    public HibernateDataSourceConfigurationAdapter(
            ObjectProvider<PersistenceUnitManager> persistenceUnitManagerProvider
            , ObjectProvider<EntityManagerFactoryBuilderCustomizer> customizers) {
        super(persistenceUnitManagerProvider, customizers);
    }

    public abstract IntegrationDataSourceProperties integrationProperties();

    @Override
    public HibernateProperties hibernateProperties() {
        return integrationProperties().getHibernate();
    }

    @Override
    public DataSourceProperties dataSourceProperties() {
        return integrationProperties().getDataSourceProps();
    }

    @Override
    public JpaProperties jpaProperties() {
        return integrationProperties().getJpa();
    }

}
