package practise1;

import freemarker.template.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;


public class HomeServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String age = request.getParameter("age");
        StringBuilder sb = new StringBuilder();

        if(name == null){
            sb.append("Name cant found");
        }else if(surname == null){
            sb.append("Name cant found");
        }else if(age == null){
            sb.append("Age must be declared");
        }

        request.setAttribute("error", sb);
        request.setAttribute("firstname", name);
        request.setAttribute("nick", surname);
        request.setAttribute("age", age);

//        Configuration configuration = new Configuration(Configuration.VERSION_2_3_21);
//        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
//        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/lesson3"));



//        writer.println(getServletContext().getRequestDispatcher("/lesson3/fuck.jsp"));
//
//        writer.println(new File("src/main/resources/lesson3/fuck.jsp").exists());
//        writer.println(new File("src/main/resources/lesson3/fuck.jsp").isFile());
//        writer.println(new File("src/main/resources/lesson3/fuck.jsp").getName());


        try{
            this.getServletContext().getRequestDispatcher("/lesson3/fuck.jsp").forward(request, response);
        }catch (Exception e){
            writer.println("Fuckin error has occured");
        }

    }
}
