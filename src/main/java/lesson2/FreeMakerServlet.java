package lesson2;

import com.sun.tools.jconsole.JConsoleContext;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class FreeMakerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources"));

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Eltaj");
        map.put("surname", "Gafarli");
        map.put("age", 21);
        map.put("id", "190407011");

        try(PrintWriter writer = response.getWriter()){
            configuration.getTemplate("test.ftl").process(map, writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }
}
