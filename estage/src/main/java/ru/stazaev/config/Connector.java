package ru.stazaev.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {

        String url = "jdbc:postgresql://localhost:5432/w-agency";
        String user = "postgres";
        String passwd = "0000";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, passwd);
    }
}
