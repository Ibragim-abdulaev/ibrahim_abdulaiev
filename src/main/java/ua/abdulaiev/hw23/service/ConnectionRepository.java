package ua.abdulaiev.hw23.service;

import lombok.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Data
public class ConnectionRepository {
    private final static String URL = "jdbc:postgresql://localhost:5432/myDB";
    private final static String PASSWORD = "root";
    private final static String USER = "postgres";
    static Connection connection = null;

    public static Connection getDBConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
