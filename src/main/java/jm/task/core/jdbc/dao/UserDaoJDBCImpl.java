package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.*;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl(Connection connection) {

    }

    public UserDaoJDBCImpl() {

    }
    private Connection connection = getConnection();

    public void createUsersTable() throws SQLException {
        String createTable = "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(45), " +
                "lastname VARCHAR(45), " +
                "age INT" +
                ")";

        try (Connection conn = getConnection();
             Statement statement = conn.createStatement()) {

            statement.executeUpdate(createTable);
            System.out.println("Таблица 'new_table' успешно создана или уже существует.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при создании таблицы: " + e.getMessage());
        }
    }

    public void dropUsersTable() {
        String dropTable = "DROP TABLE IF EXISTS users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(dropTable)) {
            preparedStatement.executeUpdate();
            System.out.println("Таблица успешно удалена, если она существовала!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при удалении Таблицы: " + e.getMessage());
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        String sql = "INSERT INTO users (name, lastname, age) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("User с именем — " + name + " добавлен в базу данных");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при добавлении пользователя: " + e.getMessage());
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь успешно удален!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при удалении пользователя: " + e.getMessage());
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> userList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                System.out.println(user.toString());
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при удалении пользователя: " + e.getMessage());
        }
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE users";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
            System.out.println("Таблица очищена!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при очищении таблицы: " + e.getMessage());
        }
    }
}
