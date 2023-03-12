package practise;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lesson2.form.Student;
import practise.form.StudentForm;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class FormServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/practise"));
        try(PrintWriter writer = response.getWriter()){
            configuration.getTemplate("form.ftl").dump(writer);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/practise"));
        HashMap<String, StudentForm> map = new HashMap<>();

        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        map.put("student", new StudentForm(name, email, password));
        try (PrintWriter writer = response.getWriter()){
            configuration.getTemplate("showstudent.ftl").process(map, writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }

    }

}
