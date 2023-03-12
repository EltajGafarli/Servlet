package hibernate.properties;

import java.util.Properties;

public class DBProperties {
    private static Properties properties(){

        Properties property = new Properties();
        property.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        property.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibertest");
        property.setProperty("hibernate.connection.username", "root");
        property.setProperty("hibernate.connection.password", "190407011");
        property.setProperty("hibernate.connection.pool_size", "1");
        property.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        property.setProperty("current_session_context_class", "thread");
        property.setProperty("cache.provider_class", "org.hibernate.cache.internal.NoCacheProvider");
        property.setProperty("hibernate.show_sql", "true");
        property.setProperty("hibernate.hbm2ddl.auto", "create");
//        org.hibernate.dialect.MySQLDialect

        return property;



    }

    public static Properties getProperties(){
        return properties();
    }
}
