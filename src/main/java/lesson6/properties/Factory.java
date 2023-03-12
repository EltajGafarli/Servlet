package lesson6.properties;

import lesson6.entity.Customer;
import lesson6.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {

    private static final SessionFactory sessionFactory = new Configuration()
            .addProperties(DBProperties.getProperties())
            .addAnnotatedClass(Student.class)
            .addAnnotatedClass(Customer.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
