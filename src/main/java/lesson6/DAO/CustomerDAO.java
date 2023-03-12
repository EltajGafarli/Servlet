package lesson6.DAO;

import jakarta.transaction.Transactional;
import lesson6.entity.Customer;
import lesson6.properties.Factory;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAO implements ICustomerDAO{

    private final static SessionFactory sessionFactory = Factory.getSessionFactory();

    @Override
    @SneakyThrows
    @Transactional
    public List<Customer> getCustomers(String sort) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query<Customer> query = session.createQuery("from Customer order by " + sort, Customer.class);

        return query.getResultList();
    }

    @Override
    @Transactional
    @SneakyThrows
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.persist(customer);

        session.getTransaction().commit();
    }

    @Override
    @Transactional
    @SneakyThrows
    public Customer getCustomerByID(Long id){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = session.get(Customer.class, id);

        session.getTransaction().commit();

        return customer;
    }

    @Override
    public void saveOrUpdate(Customer customer) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.saveOrUpdate(customer);
        session.update(customer);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public Customer getCustomerByEmail(String email) {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from customer where email=?");
        query.setParameter(1, email);
        Customer customer = query.getSingleResult();

        session.getTransaction().commit();
        session.close();

        return customer;
    }

    @Override
    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.remove(customer);
        session.getTransaction().commit();

    }

    @Override
    @Transactional
    public List<Customer> search(String name, String sort) {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer where lower(name) like \"%" + name + "%\" order by " + sort, Customer.class);
//        query.setParameter(1, name.toLowerCase());

        return query.getResultList();
    }




}
