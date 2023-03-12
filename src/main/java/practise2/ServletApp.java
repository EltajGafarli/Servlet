package practise2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServletApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        server.setHandler(handler);

        handler.addServlet(HomeServlet.class, "/home");
        handler.addServlet(BaseServlet.class, "/base");

        server.start();
        server.join();
    }
}
