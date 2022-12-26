package ru.stazaev.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.stazaev.entity.Worker;
import ru.stazaev.request.WorkerRequest;

public class WorkerService {
    private Connection connection;
    private WorkerRequest workerRequest;

    public WorkerService(Connection connection) {
        this.connection = connection;
        workerRequest = new WorkerRequest();
    }

    public List<Worker> getAll() throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(workerRequest.getAll());
        List<Worker> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(workerRequest.parse(resultSet));
        }
        return list;
    }

    public Worker get(long id) throws SQLException {
        ResultSet resultSet = connection.createStatement().executeQuery(workerRequest.get(id));
        resultSet.next();
        return workerRequest.parse(resultSet);
    }

    public void insert(Worker worker) throws SQLException {
        connection.prepareStatement(workerRequest.insert(worker)).executeUpdate();
    }

    public void delete(long id) throws SQLException {
        connection.prepareStatement(workerRequest.delete(id)).executeUpdate();
    }

    public void update(Worker worker, long id) throws SQLException {
        connection.prepareStatement(workerRequest.update(worker, id)).executeUpdate();
    }
}
