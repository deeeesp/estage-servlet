package ru.stazaev.servlet.wish;

import ru.stazaev.config.Connector;
import ru.stazaev.service.FlatService;
import ru.stazaev.service.WishService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/wish/delete")
public class WishDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        Long id = Long.valueOf(req.getParameter("id"));
        System.out.println(id);
        try {
            WishService wishService = new WishService(Connector.getConnection());
            wishService.delete(id);
            resp.sendRedirect("/wish/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}