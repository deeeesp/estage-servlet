package ru.stazaev.servlet.flat;

import ru.stazaev.config.Connector;
import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Worker;
import ru.stazaev.service.FlatService;
import ru.stazaev.service.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/flat/getAll")
public class FlatGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            FlatService flatService = new FlatService(Connector.getConnection());
            List<Flat> flats = flatService.getAll();
            System.out.println(flats);
            req.setAttribute("flats", flats);
            req.getRequestDispatcher("/flat/index.jsp").forward(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}