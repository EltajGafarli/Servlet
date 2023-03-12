package lesson5;

import lombok.SneakyThrows;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class HistoryServlet extends HttpServlet {

    private final History history;

    public HistoryServlet(History history){
        this.history = history;
    }

    @Override
    @SneakyThrows
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        try(PrintWriter writer = response.getWriter()){
            Optional<Cookie> cookie = SessionRelated.find(request);
            cookie.ifPresent(ck -> this.history.getAll(ck.getName()).stream().forEach(writer::println));
        }

    }
}
