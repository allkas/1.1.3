package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    //private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver"; //"mysql://localhost:3306/db";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/db";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            //Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to database");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }
        return connection;
    }
}
