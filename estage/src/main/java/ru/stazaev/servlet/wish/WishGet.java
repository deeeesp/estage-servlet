package ru.stazaev.servlet.wish;

import ru.stazaev.config.Connector;
import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Wish;
import ru.stazaev.service.FlatService;
import ru.stazaev.service.WishService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/wish/getAll")
public class WishGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            WishService wishService = new WishService(Connector.getConnection());
            List<Wish> wishes = wishService.getAll();
            req.setAttribute("wishes", wishes);
            req.getRequestDispatcher("/wish/index.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}