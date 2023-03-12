package hibernate;

import hibernate.entity.Student;
import hibernate.properties.DBProperties;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    private static final SessionFactory sessionFactory = new Configuration().addProperties(DBProperties.getProperties())
            .addAnnotatedClass(Student.class).buildSessionFactory();

    private static final Session session = sessionFactory.openSession();

    @SneakyThrows
    public static void main(String[] args) {
        session.beginTransaction();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }
}
