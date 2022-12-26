package ru.stazaev.servlet.client;

import ru.stazaev.config.Connector;
import ru.stazaev.service.ClientService;
import ru.stazaev.service.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/client/delete")
public class ClientDelete extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Long id = Long.valueOf(req.getParameter("id"));
        System.out.println(id);
        try {
            ClientService clientService = new ClientService(Connector.getConnection());
            clientService.delete(id);
            resp.sendRedirect("/client/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
