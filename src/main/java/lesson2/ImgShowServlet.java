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

public class ImgShowServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String file = getClass().getClassLoader().getResource("img.png").getFile();
        Path path = new File(file).toPath();

        PrintWriter writer = response.getWriter();
        writer.println(path);
        writer.println(file);

//        try (ServletOutputStream out = response.getOutputStream()){
//            Files.copy(path, out);
//        }
    }
}
