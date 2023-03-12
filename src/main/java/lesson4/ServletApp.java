package lesson4;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServletApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        server.setHandler(handler);


        handler.addServlet(HomeServlet.class, "/");
        handler.addServlet(FormForwardServlet.class, "/form");
        handler.addServlet(CatcherSevlet.class, "/catcher");

        server.start();
        server.join();
    }
}
