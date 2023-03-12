package lesson5;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class ServletApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        server.setHandler(handler);

        History history = new HistoryService();

        HistoryServlet historyServlet = new HistoryServlet(history);
        Calc calc = new Calc(history);

        handler.addServlet(HomeServlet.class, "/");
        handler.addServlet(new ServletHolder(calc), "/calc");
        handler.addServlet(LogoutServlet.class, "/logout");
        handler.addServlet(new ServletHolder(historyServlet), "/history");

        server.start();
        server.join();
    }
}
