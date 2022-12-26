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

@WebServlet("/client/insert")
public class ClientInsert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("username");
        int number = Integer.parseInt(req.getParameter("number"));
        try {
            ClientService clientService = new ClientService(Connector.getConnection());
            clientService.insert(new Client(name,number));
            resp.sendRedirect("/client/getAll");
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
