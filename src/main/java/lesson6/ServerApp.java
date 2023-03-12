package lesson6;

import lesson6.controller.*;
import lombok.SneakyThrows;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServerApp {

    @SneakyThrows
    public static void main(String[] args) {
        Server server = new Server(8080);

        ServletContextHandler servletContextHandler = new ServletContextHandler();

        server.setHandler(servletContextHandler);

        servletContextHandler.addServlet(HelloServlet.class, "/");
        servletContextHandler.addServlet(AddCustomerServlet.class, "/addCustomer");
        servletContextHandler.addServlet(CustomerListServlet.class, "/customers");
        servletContextHandler.addServlet(UpdateCustomerServlet.class, "/update");
        servletContextHandler.addServlet(DeleteCustomerServlet.class, "/delete");

        server.start();
        server.join();
    }
}
