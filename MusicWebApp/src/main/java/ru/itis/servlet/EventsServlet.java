package ru.itis.servlet;

import ru.itis.service.EventService;
import ru.itis.service.impl.EventServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "eventsServlet", urlPatterns = "/events")
public class EventsServlet extends HttpServlet {

    private final EventService eventService = new EventServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("events", eventService.getAll());
        req.getRequestDispatcher("events.ftl").forward(req, resp);
    }
}
