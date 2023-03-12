package lesson6.DAO;

import jakarta.transaction.Transactional;
import lesson6.entity.Customer;
import lombok.SneakyThrows;

import java.util.List;

public interface ICustomerDAO {

    List<Customer> getCustomers(String sort);

    void save(Customer customer);


    Customer getCustomerByID(Long id);

    void saveOrUpdate(Customer customer);

    Customer getCustomerByEmail(String email);

    void delete(Customer customer);

    List<Customer> search(String name, String sort);

}
