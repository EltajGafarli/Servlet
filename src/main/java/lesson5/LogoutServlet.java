package lesson5;

import freemarker.ext.servlet.FreemarkerServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class LogoutServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Optional<Cookie> cookie = SessionRelated.find(request);

        cookie.ifPresent(ck -> {
            ck.setMaxAge(0);
            response.addCookie(ck);
        });




        try(PrintWriter writer = response.getWriter()){

            writer.println(cookie.map(x -> "Cookie is found").orElse("Not found"));
        }

    }
}
