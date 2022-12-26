package ru.stazaev.servlet.client;

import ru.stazaev.config.Connector;
import ru.stazaev.entity.Client;
import ru.stazaev.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/client/update")
public class ClientUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            ClientService clientService = new ClientService(Connector.getConnection());
            int id = Integer.parseInt(req.getParameter("id"));
            Client client = clientService.get(id);
            req.setAttribute("client", client);
            getServletContext().getRequestDispatcher("/client/worker-edit.jsp").forward(req, resp);
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
        Client client = new Client(id, name, number);
        try {
            ClientService clientService = new ClientService(Connector.getConnection());
            clientService.update(client, id);
            resp.sendRedirect("/client/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
