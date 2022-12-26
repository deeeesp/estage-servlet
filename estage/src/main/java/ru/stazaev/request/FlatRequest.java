package ru.stazaev.request;

import ru.stazaev.entity.Flat;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlatRequest {
    public  String insert(Flat flat) {
        return "Insert into flats(id_worker,meters,floor,rooms) VALUES('" +
                flat.getWorker_id() + "'," +
                flat.getMeters() + "," +
                flat.getFloor() + "," +
                flat.getRooms() + ")";
    }

    public String update(Flat flat, long id) {
        return "UPDATE flats SET id_worker = " + flat.getWorker_id() +
                ", meters = " + flat.getMeters() +
                ", floor = " + flat.getFloor() +
                ", rooms = " + flat.getRooms() +
                " WHERE id_flat = " + id;
    }

    public  String delete(long id) {
        return "DELETE FROM flats WHERE id_flat = " + id;
    }

    public  String get(long id) {
        return "select * from flats where id_flat = " + id;
    }

    public  String getAll() {
        return "select * from flats";
    }

    public  Flat parse(ResultSet resultSet) throws SQLException {
        return new Flat(resultSet.getLong("id_flat"),
                resultSet.getLong("id_worker"),
                resultSet.getInt("meters"),
                resultSet.getInt("floor"),
                resultSet.getInt("rooms"));
    }
}
