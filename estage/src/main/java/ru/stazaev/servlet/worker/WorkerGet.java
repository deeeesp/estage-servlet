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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/worker/getAll")
public class WorkerGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            WorkerService workerService = new WorkerService(Connector.getConnection());
            List<Worker> workers = workerService.getAll();
            System.out.println(workers);
            req.setAttribute("workers", workers);
            req.getRequestDispatcher("/worker/index.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
