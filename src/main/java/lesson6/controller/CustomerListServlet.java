package lesson6.controller;

import freemarker.template.Configuration;
import jakarta.transaction.Transactional;
import lesson6.DAO.CustomerDAO;
import lesson6.entity.Customer;
import lesson6.properties.Factory;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CustomerListServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/lesson6"));

        Optional<String> searchName = Optional.ofNullable(req.getParameter("searchName"));

        Optional<String> sort = Optional.ofNullable(req.getParameter("sort"));

        CustomerDAO customerDAO = new CustomerDAO();

        List<Customer> customers = null;

        if(searchName.isPresent()) {
            customers = customerDAO.search(searchName.get(), sort.orElse("id"));
        }else{
            customers = customerDAO.getCustomers(sort.orElse("id"));
        }

        String count = customers.size() == 0 ? "Not Found" : String.valueOf(customers.size()) + " found";

        HashMap<String, Object> map = new HashMap<>();
        map.put("customers", customers);
        map.put("count", count);

        try(PrintWriter writer = resp.getWriter()){
            configuration.getTemplate("showCustomer.ftl").process(map, writer);
        }
    }
}
