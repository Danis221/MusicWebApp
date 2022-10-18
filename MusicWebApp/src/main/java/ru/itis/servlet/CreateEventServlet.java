package ru.itis.servlet;

import ru.itis.models.Event;
import ru.itis.service.EventService;
import ru.itis.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createEventServlet", urlPatterns = "/createEvent")
public class CreateEventServlet extends HttpServlet {

    private final EventService eventService = new EventServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("createEvent.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String performer = req.getParameter("performer");
        String concertDate = req.getParameter("concertDate");
        String price = req.getParameter("price");
        String venue = req.getParameter("venue");

        if (price.trim().length() != 0 && performer.trim().length() != 0 && concertDate.trim().length() != 0 && venue.trim().length() != 0) {
            Event event = new Event(performer, concertDate, Integer.parseInt(price), venue);
            eventService.save(event);
            resp.sendRedirect("/");
        } else  {
            req.setAttribute("error", "something is not filled");
            req.getRequestDispatcher("createEvent.ftl").forward(req, resp);
        }
    }
}
