package lesson1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(HelloServlet.class, "/hello");
        handler.addServlet(XMLServlet.class, "/xml");
        handler.addServlet(Form.class, "/form");
        handler.addServlet(CalculatorServlet.class, "/calc");


        Counter counter = new Counter();

        CounterServlet counterServlet = new CounterServlet(counter);

        handler.addServlet(new ServletHolder(counterServlet), "/count");

        server.setHandler(handler);
        server.start();
        server.join();



    }
}
