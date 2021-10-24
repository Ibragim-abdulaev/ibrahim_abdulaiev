package ua.abdulaiev.hw23.service;

import ua.abdulaiev.hw23.object.Device;
import ua.abdulaiev.hw23.object.Factory;
import ua.abdulaiev.hw23.object.ModelType;

import java.sql.*;
import java.util.Date;

public class ServiceRepository {

    public static void getDevicesListByFactoryId(int id) {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT * FROM Device" +
                    " INNER JOIN Factory ON Factory.id_factory = fc_id WHERE Factory.id_factory = " + id;
            connection = ConnectionRepository.getDBConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            System.out.println("List factory id:" + id);
            if (resultSet.next()) {
                do {
                    int i = 1;
                    while (i <= columns) {
                        System.out.print(resultSet.getString(i) + " ");
                        i++;
                    }
                    System.out.println();
                } while (resultSet.next());
            }
            System.out.println();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeDeviceForPrice(int id) {
        Connection connection;
        PreparedStatement statement;
        try {
            String sqlUpdatePrice = "UPDATE Device SET price = 4500 WHERE id_device = " + id;
            connection = ConnectionRepository.getDBConnection();
            statement = connection.prepareStatement(sqlUpdatePrice);
            statement.executeUpdate();
            System.out.println("Id:" + id + " the price value was changed");
            System.out.println();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getDeviceAndFactory(int id) {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sqlGetDevice = "SELECT * FROM Device WHERE id_device = " + id;
            String sqlGetFactory = "SELECT * FROM Factory WHERE id_factory IN (SELECT fc_id FROM Device WHERE id_device = " + id + ")";
            connection = ConnectionRepository.getDBConnection();
            statement = connection.prepareStatement(sqlGetDevice);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                do {
                    int idDevices = resultSet.getInt("id_device");
                    String typeDevice = resultSet.getString("type");
                    String modelDevice = resultSet.getString("device_model");
                    int price = resultSet.getInt("price");
                    Date date = resultSet.getDate("date");
                    String descriptionDevice = resultSet.getString("description");
                    boolean stockAvailability = resultSet.getBoolean("stockAvailability");
                    int idFactory = resultSet.getInt("fc_id");
                    ModelType deviceType = null;
                    switch (typeDevice) {
                        case ("Telephone") -> deviceType = ModelType.PHONE;
                        case ("Television") -> deviceType = ModelType.TV;
                    }
                    Device device = new Device(idDevices, deviceType, modelDevice, price, date, descriptionDevice, stockAvailability, idFactory);
                    System.out.println();
                    System.out.println(device);
                } while (resultSet.next());
            }
            statement = connection.prepareStatement(sqlGetFactory);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                do {
                    int idFactories = resultSet.getInt("id_factory");
                    String name = resultSet.getString("name");
                    String country = resultSet.getString("country");
                    Factory factory = new Factory(idFactories, name, country);
                    System.out.println(factory);
                } while (resultSet.next());
            }
            System.out.println();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getSumAndCountObject() {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String sql = "SELECT fc_id , COUNT(*) AS Allcount, SUM(price)" +
                    " AS AllPrice FROM Device GROUP BY fc_id ORDER BY fc_id";
            connection = ConnectionRepository.getDBConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            System.out.println("Amount and the sum of all objects of the Factory");
            if (resultSet.next()) {
                do {
                    for (int i = 1; i <= columns; i++) {
                        System.out.print(resultSet.getString(i) + " ");
                    }
                    System.out.println();
                } while (resultSet.next());
            }
            System.out.println();
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteObjectDeviceTable(int id) {
        Connection connection;
        PreparedStatement statement;
        try {
            String sql = "DELETE FROM Device WHERE id_device=" + id + ";";
            connection = ConnectionRepository.getDBConnection();
            statement = connection.prepareStatement(sql);

            statement.executeUpdate();
            System.out.println("Delete Device id: " + id);
            System.out.println();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
