package lesson6.controller;

//import jakarta.validation.ValidationException;
import freemarker.template.Configuration;
import lesson6.entity.Customer;
import lesson6.entity.Student;
import lesson6.properties.DBProperties;
import lombok.Cleanup;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HelloServlet extends HttpServlet {

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/lesson6"));

        try(PrintWriter writer = response.getWriter()){
            configuration.getTemplate("home.ftl").dump(writer);
        }
    }

    @Override
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
