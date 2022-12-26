package ru.stazaev.service;

import ru.stazaev.entity.Wish;
import ru.stazaev.entity.Worker;
import ru.stazaev.request.WishRequest;
import ru.stazaev.request.WorkerRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishService {
    private Connection connection;
    private WishRequest wishRequest;

    public WishService(Connection connection) {
        this.connection = connection;
        wishRequest = new WishRequest();
    }

    public Wish get(long id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(wishRequest.get(id));
        resultSet.next();
        return wishRequest.parse(resultSet);
    }

    public List<Wish> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(wishRequest.getAll());
        List<Wish> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(wishRequest.parse(resultSet));
        }
        return list;
    }

    public void insert(Wish wish) throws SQLException {
        connection.prepareStatement(wishRequest.insert(wish)).executeUpdate();
    }

    public void delete(long id) throws SQLException {
        connection.prepareStatement(wishRequest.delete(id)).executeUpdate();
    }

    public void update(Wish wish, long id) throws SQLException {
        connection.prepareStatement(wishRequest.update(wish, id)).executeUpdate();
    }
}
