package lesson1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CounterServlet extends HttpServlet {


    private final Counter counter;

    public CounterServlet(Counter counter){
        this.counter = counter;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("Increment...");



        this.counter.inc();

        writer.println("Value = " + this.counter.getX());

    }
}
