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

@WebServlet("/worker/update")
public class WorkerUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            WorkerService workerService = new WorkerService(Connector.getConnection());
            int id = Integer.parseInt(req.getParameter("id"));
            Worker worker = workerService.get(id);
            System.out.println(worker);
            req.setAttribute("worker", worker);
            getServletContext().getRequestDispatcher("/worker/worker-edit.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//            WorkerService workerService = new WorkerService(Connector.getConnection());
//            workerService.update(new Worker("name",141),5);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int number = Integer.parseInt(req.getParameter("number"));
        Worker worker = new Worker(id,name,number);
        try {
            WorkerService workerService = new WorkerService(Connector.getConnection());
            workerService.update(worker,id);
            resp.sendRedirect("/worker/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
