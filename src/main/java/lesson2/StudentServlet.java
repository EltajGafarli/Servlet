package lesson2;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import lesson2.form.Student;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources"));

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Eltaj", "Gafarli", "eltaj@gmail.com"));
        students.add(new Student(2, "Yaqub", "Orucov", "yaqub@gmail.com"));
        students.add(new Student(3, "Nural", "AKbarov", "nural@gmail.com"));

        HashMap<String, Object> map = new HashMap<>();
        map.put("student", students);

        try(PrintWriter writer = response.getWriter()){
            configuration.getTemplate("student.ftl").process(map, writer);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
