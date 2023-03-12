package lesson2;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Img1ShowServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        PrintWriter writer = response.getWriter();
        String file = getClass().getClassLoader().getResource("img_1.png").getFile();

        Path path = new File(file).toPath();

        try(ServletOutputStream out = response.getOutputStream()){
            Files.copy(path, out);
        }
    }
}
