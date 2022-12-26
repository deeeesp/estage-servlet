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

@WebServlet("/worker/update")
public class FlatUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            FlatService flatService = new FlatService(Connector.getConnection());
            int id = Integer.parseInt(req.getParameter("id"));
            Flat flat = flatService.get(id);
            System.out.println(flat);
            req.setAttribute("flat", flat);
            getServletContext().getRequestDispatcher("/flat/flat-edit.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//            WorkerService workerService = new WorkerService(Connector.getConnection());
//            workerService.update(new Worker("name",141),5);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int wid = Integer.parseInt(req.getParameter("wid"));
        int meters = Integer.parseInt(req.getParameter("meters"));
        int floor = Integer.parseInt(req.getParameter("floor"));

        int rooms = Integer.parseInt(req.getParameter("rooms"));
        Flat flat = new Flat(id,wid,meters,floor,rooms);
        try {
            FlatService flatService = new FlatService(Connector.getConnection());
            flatService.update(flat,id);
            resp.sendRedirect("/flat/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
