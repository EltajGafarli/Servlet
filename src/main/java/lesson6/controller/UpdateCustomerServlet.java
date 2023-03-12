package lesson6.controller;

import freemarker.template.Configuration;
import lesson6.DAO.CustomerDAO;
import lesson6.entity.Customer;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class UpdateCustomerServlet extends HttpServlet {


    @Override
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/lesson6"));

        CustomerDAO customerDAO = new CustomerDAO();
        long id = Long.parseLong(request.getParameter("id"));

        Customer customerByID = customerDAO.getCustomerByID(id);

        HashMap<String, Customer> map = new HashMap<>();
        map.put("customer", customerByID);

        try(PrintWriter writer = response.getWriter()){
            configuration.getTemplate("customer.ftl").process(map, writer);
        }

    }


    @Override
    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");


//        Customer customer = new Customer(name, surname, email);

        CustomerDAO customerDAO = new CustomerDAO();

        Customer customer = customerDAO.getCustomerByID(Long.parseLong(request.getParameter("id")));

        customer.setName(name);
        customer.setSurname(surname);
        customer.setEmail(email);

        customerDAO.saveOrUpdate(customer);

        response.sendRedirect("/customers");

    }


}
