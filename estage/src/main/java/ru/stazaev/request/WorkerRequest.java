package ru.stazaev.request;

import ru.stazaev.entity.Worker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerRequest {
    public String insert(Worker worker){
        System.out.println("Insert into workers(name,number) VALUES('"+
                worker.getName() + "','" +
                worker.getTelephone() +"')");
        return "Insert into workers(name,number) VALUES('"+
                worker.getName() + "','" +
                worker.getTelephone() +"')";
    }

    public  String update(Worker worker, long id){
        return "UPDATE workers SET name = '" + worker.getName() +
                "', number = '" + worker.getTelephone() +
                "' WHERE id_worker = " + id;
    }

    public static String join(long id){
        return "SELECT * FROM workers FULL OUTER JOIN flats f " +
                "on workers.id_worker = f.id_worker where workers.id_worker =" + id;
    }


    public String delete(long id){
        return "DELETE FROM workers WHERE id_worker = " + id;
    }

    public  String get(long id){
        return "select * from workers where id_worker = " + id;
    }

    public String getAll(){
        return "select * from workers";
    }

    public Worker parse(ResultSet resultSet) throws SQLException {
        return new Worker(resultSet.getLong("id_worker"),
                resultSet.getString("name"),
                resultSet.getInt("number"));
    }
}
