package org.finn.demo.base;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author Finn Zhao
 * @version 2019-11-23
 */
public class IntegrationDataSourceProperties {

    @NestedConfigurationProperty
    private DataSourceProperties dataSourceProps;

    @NestedConfigurationProperty
    private JpaProperties jpa;

    @NestedConfigurationProperty
    private HibernateProperties hibernate;

    public DataSourceProperties getDataSourceProps() {
        return dataSourceProps;
    }

    public void setDataSourceProps(DataSourceProperties dataSourceProps) {
        this.dataSourceProps = dataSourceProps;
    }

    public JpaProperties getJpa() {
        return jpa;
    }

    public void setJpa(JpaProperties jpa) {
        this.jpa = jpa;
    }

    public HibernateProperties getHibernate() {
        return hibernate;
    }

    public void setHibernate(HibernateProperties hibernate) {
        this.hibernate = hibernate;
    }
}
