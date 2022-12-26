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
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/worker/insert")
public class WorkerInsert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("username");
        int number = Integer.parseInt(req.getParameter("number"));
        try {
            WorkerService workerService = new WorkerService(Connector.getConnection());
            workerService.insert(new Worker(name,number));
            resp.sendRedirect("/worker/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Age: " + number + "</p>");
        } finally {
            writer.close();
        }
    }
}
