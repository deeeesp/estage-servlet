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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/wishes/update")
public class WishUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            WishService wishService = new WishService(Connector.getConnection());
            int id = Integer.parseInt(req.getParameter("id"));
            Wish wish = wishService.get(id);
            System.out.println(wish);
            req.setAttribute("wish", wish);
            getServletContext().getRequestDispatcher("/wish/wish-edit.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//            WorkerService workerService = new WorkerService(Connector.getConnection());
//            workerService.update(new Worker("name",141),5);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int wid = Integer.parseInt(req.getParameter("wid"));
        int meters = Integer.parseInt(req.getParameter("meters"));
        int rooms = Integer.parseInt(req.getParameter("rooms"));
        int cost = Integer.parseInt(req.getParameter("cost"));
        Wish wish = new Wish(wid,meters,rooms,cost);
        try {
            WishService wishService = new WishService(Connector.getConnection());
            wishService.update(wish,id);
            resp.sendRedirect("/wish/getAll");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
