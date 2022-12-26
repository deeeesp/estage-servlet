package ru.stazaev.service;

import ru.stazaev.entity.Flat;
import ru.stazaev.entity.Wish;
import ru.stazaev.request.FlatRequest;
import ru.stazaev.request.WishRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlatService {
    private Connection connection;
    private FlatRequest flatRequest;

    public FlatService(Connection connection) {
        this.connection = connection;
        flatRequest = new FlatRequest();
    }

    public Flat get(long id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(flatRequest.get(id));
        resultSet.next();
        return flatRequest.parse(resultSet);
    }

    public List<Flat> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(flatRequest.getAll());
        List<Flat> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(flatRequest.parse(resultSet));
        }
        return list;
    }

    public void insert(Flat flat) throws SQLException {
        connection.prepareStatement(flatRequest.insert(flat)).executeUpdate();
    }

    public void delete(long id) throws SQLException {
        connection.prepareStatement(flatRequest.delete(id)).executeUpdate();
    }

    public void update(Flat flat, long id) throws SQLException {
        connection.prepareStatement(flatRequest.update(flat, id)).executeUpdate();
    }
}
