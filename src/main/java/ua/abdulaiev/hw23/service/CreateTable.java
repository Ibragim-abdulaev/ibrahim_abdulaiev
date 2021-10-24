package ua.abdulaiev.hw23.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static ua.abdulaiev.hw23.service.ConnectionRepository.getDBConnection;

public class CreateTable {
    public static void createTables() {
        Connection connection;
        PreparedStatement statement;
        try {
            String createTablesFactory = "CREATE TABLE Factory " +
                    "(id_factory serial PRIMARY KEY," +
                    "name varchar(50) NOT NULL," +
                    "country varchar(50) NOT NULL);";
            String createTablesDevice =
                    "CREATE TABLE Device " +
                    "(id_device serial PRIMARY KEY," +
                    "type varchar(50) NOT NULL," +
                    "device_model varchar(50) NOT NULL," +
                    "price int," +
                    "date DATE NOT NULL," +
                    "description text, " +
                    "stockAvailability boolean," +
                    "fc_id int REFERENCES Factory(id_factory));";

            connection = getDBConnection();
            statement = connection.prepareStatement(createTablesFactory);
            statement.executeUpdate();
            statement = connection.prepareStatement(createTablesDevice);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}