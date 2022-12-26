package ru.stazaev.request;

import ru.stazaev.entity.Wish;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WishRequest {
    public  String insert(Wish wish) {
        return "Insert into wishes(id_client,meters,floor,cost) VALUES(" +
                wish.getId_client() + "," +
                wish.getMeters() + "," +
                wish.getRooms() + "," +
                wish.getCost() + ")";
    }

    public  String update(Wish wish, long id) {
        return "UPDATE wishes SET id_client = " + wish.getId_client() +
                " meters = " + wish.getMeters() +
                " floor = " + wish.getRooms() +
                " cost = " + wish.getCost() +
                " WHERE id_wish = " + id;
    }

    public  String delete(long id) {
        return "DELETE FROM wishes WHERE id_wish = " + id;
    }

    public  String get(long id) {
        return "select * from wishes where id_wish = " + id;
    }

    public  String getAll() {
        return "select * from wishes";
    }

    public  Wish parse(ResultSet resultSet) throws SQLException {
        return new Wish(resultSet.getLong("id_wish"),
                resultSet.getLong("id_client"),
                resultSet.getInt("meters"),
                resultSet.getInt("floor"),
                resultSet.getInt("cost"));
    }
}
