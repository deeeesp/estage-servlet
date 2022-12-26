package ru.stazaev.servlet.worker;

import ru.stazaev.config.Connector;
import ru.stazaev.entity.Worker;
import ru.stazaev.service.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/worker/delete")
public class WorkerDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Long id = Long.valueOf(req.getParameter("id"));
        System.out.println(id);
        try {
            WorkerService workerService = new WorkerService(Connector.getConnection());
            workerService.delete(id);
            resp.sendRedirect("/worker/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
