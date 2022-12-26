package ru.stazaev.servlet.flat;

import ru.stazaev.config.Connector;
import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Worker;
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

@WebServlet("/worker/insert")
public class FlatInsert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int wid = Integer.parseInt(req.getParameter("wid"));
        int meters = Integer.parseInt(req.getParameter("meters"));
        int floor = Integer.parseInt(req.getParameter("floor"));
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        try {
            FlatService flatService = new FlatService(Connector.getConnection());
            flatService.insert(new Flat(wid,meters,floor,rooms));
            resp.sendRedirect("/flat/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
