package ua.abdulaiev.hw23.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static ua.abdulaiev.hw23.service.ConnectionRepository.getDBConnection;
import static ua.abdulaiev.hw23.object.Device.*;
import static ua.abdulaiev.hw23.object.Factory.*;

public class AddObjects {
    static PreparedStatement statement = null;
    static Connection connection = null;
    public static void fillTableDevice() {
        try {
            String addObjectDevice =
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Television', 'Xiaomi', 5555, '2002-06-14', 'text1', false, 3);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Television', 'Samsung', 4322, '2008-01-31', 'text2', false, 1);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Telephone', 'Xiaomi', 3845, '2010-12-23', 'text3', true, 2);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Telephone', 'Huawei', 3134, '2001-10-13', 'text4', true, 4);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Television', 'Samsung', 9350, '2018-11-21', 'text5', true, 1);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Telephone', 'OnePlus', 9400, '2015-12-23', 'text6', false, 3);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Television', 'OPPO', 2100, '2006-09-27', 'text7', false, 2);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Telephone', 'Apple', 12200, '2005-07-25', 'text8', true, 4);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Telephone', 'Motorola', 5700, '2000-04-05', 'text9', true, 2);" +
                    "INSERT INTO Device (type, device_model, price, date, description, stockAvailability, fc_id)" +
                    "VALUES ('Television', 'Smart', 5460, '2012-02-12', 'text10', true, 4);";
            connection = getDBConnection();
            statement = connection.prepareStatement(addObjectDevice);
            statement.executeUpdate();
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillTableFactory() {
        try {
            String addObjectFactory =
                    "INSERT INTO Factory (name, country) VALUES ('Shoe', 'China');" +
                    "INSERT INTO Factory (name, country) VALUES ('Machine', 'Ukraine');" +
                    "INSERT INTO Factory (name, country) VALUES ('Door', 'France');" +
                    "INSERT INTO Factory (name, country) VALUES ('Clothing', 'Italia');";

            connection = getDBConnection();
            statement = connection.prepareStatement(addObjectFactory);
            statement.executeUpdate();
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}