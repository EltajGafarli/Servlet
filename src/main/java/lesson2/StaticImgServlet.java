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
import java.util.Objects;

public class StaticImgServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getPathInfo().substring(1);

        String fileName = getClass().getClassLoader().getResource(path).getFile();

        Path path1 = new File(fileName).toPath();

        try(ServletOutputStream out = response.getOutputStream()){
            Files.copy(path1, out);
        }


    }
}
