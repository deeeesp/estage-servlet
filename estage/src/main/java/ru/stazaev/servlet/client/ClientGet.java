package ru.stazaev.servlet.client;

import ru.stazaev.config.Connector;
import ru.stazaev.entity.Client;
import ru.stazaev.entity.Worker;
import ru.stazaev.service.ClientService;
import ru.stazaev.service.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/client/getAll")
public class ClientGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ClientService clientService = new ClientService(Connector.getConnection());
            List<Client> clients = clientService.getAll();
            System.out.println(clients);
            req.setAttribute("clients", clients);
            req.getRequestDispatcher("/client/index.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}