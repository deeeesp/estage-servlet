package ru.stazaev.servlet.flat;

import ru.stazaev.config.Connector;
import ru.stazaev.entity.Flat;
import ru.stazaev.service.FlatService;
import ru.stazaev.service.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/flat/delete")
public class FlatDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Long id = Long.valueOf(req.getParameter("id"));
        System.out.println(id);
        try {
            FlatService flatService = new FlatService(Connector.getConnection());
            flatService.delete(id);
            resp.sendRedirect("/flat/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}