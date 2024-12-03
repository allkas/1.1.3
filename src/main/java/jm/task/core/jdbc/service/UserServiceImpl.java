package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    public void createUsersTable() throws SQLException {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        UserDaoJDBCImpl userDao1 = userDao;
        userDao1.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        UserDaoJDBCImpl userDao1 = userDao;
        userDao1.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        UserDaoJDBCImpl userDao1 = userDao;
        userDao1.removeUserById(id);
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.cleanUsersTable();
    }
}
