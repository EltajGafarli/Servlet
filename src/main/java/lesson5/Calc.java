package lesson5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

public class Calc extends HttpServlet {

    private final History history;

    public Calc(History history){
        this.history = history;
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Optional<Cookie> cookie = SessionRelated.find(request);

        Optional<String> cookie_val = cookie.map(Cookie::getValue);

        if(cookie_val.isEmpty()){
            response.addCookie(SessionRelated.newRandom());
        }

        PrintWriter writer = response.getWriter();

        writer.printf("%s \n", cookie_val.orElse("Cant FIND"));
        writer.println(cookie);

        writer.println(Arrays.toString(request.getCookies()));
        writer.println(request.getCookies().length);
        writer.println(request.getCookies()[0].getValue());
        writer.println(request.getCookies()[0].getName());
        writer.println(cookie_val);

        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));

        int z = x + y;

        writer.println(x + " + " + y + " = "  + z);


        cookie.ifPresent(ck -> this.history.save(ck.getName(), new HistoryItem(x, y, z)));


    }
}
