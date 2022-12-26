package ru.stazaev.request;

import ru.stazaev.entity.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRequest {
    public  String insert(Client client){
        return "Insert into clients(name,telephone) VALUES('"+
                client.getName() + "','" +
                client.getTelephone() +"')";
    }

    public  String update(Client client, long id){
        return "UPDATE clients SET name = '" + client.getName() +
                "' telephone = '" + client.getTelephone() +
                "' WHERE id_client = " + id;
    }

    public  String delete(long id){
        return "DELETE FROM clients WHERE id_client = " + id;
    }

    public  String get(long id){
        return "select * from clients where id_client = " + id;
    }

    public String getAll(){
        return "select * from clients";
    }

    public Client parse(ResultSet resultSet) throws SQLException {
        return new Client(resultSet.getLong("id_client"),
                resultSet.getString("name"),
                resultSet.getString("telephone"));
    }

}
