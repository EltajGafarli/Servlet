package lesson1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(urlPatterns = {"/fuck"})
public class XMLServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Get Method is Still Working");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter writer = response.getWriter();
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");

        writer.println("Welcome Fucking ...");

        writer.printf("Name: %s Password: %s", name, pass);
    }
}
