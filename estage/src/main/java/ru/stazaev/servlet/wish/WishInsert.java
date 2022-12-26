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

@WebServlet("/worker/insert")
public class WishInsert extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int wid = Integer.parseInt(req.getParameter("wid"));
        int meters = Integer.parseInt(req.getParameter("meters"));
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        int cost = Integer.parseInt(req.getParameter("cost"));
        try {
            WishService wishService = new WishService(Connector.getConnection());
            wishService.insert(new Wish(wid,meters,rooms,cost));
            resp.sendRedirect("/flat/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
