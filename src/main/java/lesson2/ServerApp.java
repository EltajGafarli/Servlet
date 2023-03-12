package lesson2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();

        server.setHandler(handler);

        handler.addServlet(HelloServlet.class, "/hello");

        handler.addServlet(FreeMakerServlet.class, "/ftl");
        handler.addServlet(StudentServlet.class, "/student");
//        handler.addServlet(ImgShowServlet.class, "/img");

//        handler.addServlet(Img1ShowServlet.class, "/img1");
        handler.addServlet(StaticImgServlet.class, "/*");
//        handler.addServlet(HomeServlet.class, "/");

        server.start();
        server.join();
    }
}
