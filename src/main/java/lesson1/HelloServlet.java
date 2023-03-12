package lesson1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
//    http://localhost:8080/hello?x=5&y=7
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String xs = request.getParameter("x");
        String ys = request.getParameter("y");
        String op = request.getParameter("op");

        if(xs == null || ys == null || op == null){
            PrintWriter writer = response.getWriter();
            writer.println("Hello Error occured!!!");
            return;
        }

        Integer x = Integer.parseInt(xs);
        Integer y = Integer.parseInt(ys);

        PrintWriter writer = response.getWriter();

        if("plus".compareToIgnoreCase(op) == 0){
            writer.printf("Thanks for using!  %d + %d = %d", x, y, x + y);
        }else if("minus".compareToIgnoreCase(op) == 0){
            writer.printf("Thanks for using!  %d - %d = %d", x, y, x - y);
        }else if("mul".compareToIgnoreCase(op) == 0){
            writer.printf("Thanks for using!  %d x %d = %d", x, y, x * y);
        }else if("div".compareToIgnoreCase(op) == 0){
            writer.printf("Thanks for using!  %d : %d = %f", x, y, (double)x / y);
        }else{
            writer.println("Please Try Again!");
        }

//        writer.printf("Hello %d + %d = %d", x, y, x + y);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("user");
        String password = request.getParameter("password");

        writer.printf("Name: %s, Password %s", name, password);
        
    }
}
