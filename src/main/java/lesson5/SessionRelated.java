package lesson5;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.UUID;

public class SessionRelated {
    private static final String COOKIE_NAME = "user_id";

    public static Optional<Cookie> find(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals(COOKIE_NAME)){
                    return Optional.of(cookie);
                }
            }
        }

        return Optional.empty();
    }


    public static Cookie newRandom(){
        return new Cookie(COOKIE_NAME, UUID.randomUUID().toString());
    }
}
