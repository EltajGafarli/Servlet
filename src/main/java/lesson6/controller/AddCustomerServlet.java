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

public class AddCustomerServlet extends HttpServlet {


    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/lesson6"));
        try(PrintWriter writer = resp.getWriter()){
            configuration.getTemplate("addCustomer.ftl").dump(writer);
        }

    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");

        Customer customer = new Customer(name, surname, email);

        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.save(customer);

        resp.sendRedirect("/customers");

    }
}
