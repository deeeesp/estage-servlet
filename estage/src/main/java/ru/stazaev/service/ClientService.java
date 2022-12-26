package ru.stazaev.service;

import ru.stazaev.entity.Client;
import ru.stazaev.entity.Flat;
import ru.stazaev.request.ClientRequest;
import ru.stazaev.request.FlatRequest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private Connection connection;
    private ClientRequest clientRequest;

    public ClientService(Connection connection) {
        this.connection = connection;
        clientRequest = new ClientRequest();
    }

    public Client get(long id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(clientRequest.get(id));
        resultSet.next();
        return clientRequest.parse(resultSet);
    }

    public List<Client> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(clientRequest.getAll());
        List<Client> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(clientRequest.parse(resultSet));
        }
        return list;
    }

    public void insert(Client client) throws SQLException {
        connection.prepareStatement(clientRequest.insert(client)).executeUpdate();
    }

    public void delete(long id) throws SQLException {
        connection.prepareStatement(clientRequest.delete(id)).executeUpdate();
    }

    public void update(Client client, long id) throws SQLException {
        connection.prepareStatement(clientRequest.update(client, id)).executeUpdate();
    }
}
