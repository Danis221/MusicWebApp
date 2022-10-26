package ru.itis.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/ajax/bts")
public class AjaxBtsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        String [] namesArr={"Nadjyn","Chonguk","Chingachkyk","Goiko","Mitch","Djin","Uingi"};
        Random r = new Random();
        String randomName = namesArr[r.nextInt(namesArr.length)];

        resp.getWriter().write(String.format("You are " + randomName));
    }
}