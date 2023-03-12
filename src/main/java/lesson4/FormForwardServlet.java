package lesson4;

import freemarker.template.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.File;

@WebServlet(value = "/form")
public class FormForwardServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/lesson4"));
        try(PrintWriter writer = response.getWriter()){
            configuration.getTemplate("/form.ftl").dump(writer);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        File file = new File("src/main/resources/lesson4/forward.html");
//
        PrintWriter writer = response.getWriter();
//        writer.println("is this fucking file exist? - " + file.exists());
//        writer.println(file.getPath());
        try{
            response.sendRedirect("/catcher");
        }
        catch (NullPointerException exc){
            writer.println("Error Has occured");
            writer.println(exc.getMessage());
        }
    }
}
