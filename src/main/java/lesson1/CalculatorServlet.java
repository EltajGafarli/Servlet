package lesson1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        String x = req.getParameter("x");
//        String y = req.getParameter("y");
//
//        int xs = Integer.parseInt(x);
//        int ys = Integer.parseInt(y);
//
//        writer.println("Result is: " + (xs + ys));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String x = request.getParameter("x");
        String y = request.getParameter("y");

        int xs = Integer.parseInt(x);
        int ys = Integer.parseInt(y);

        writer.println("Result is: " + (xs + ys));
    }
}
