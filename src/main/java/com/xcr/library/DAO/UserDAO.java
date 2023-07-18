package com.xcr.library.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/xcr_assignment_java";
        String username = "root";
        String pass = "2025" ;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, pass );
    }

    public int addUser(User user) throws SQLException {
        String query = "INSERT INTO users (userId, name, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, user.getUserId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());

        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            user.setUserId(id);
            return id;
        } else {
            return -1; // return -1 if no ID was generated
        }
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("userId");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            User user = new User( id, name, email, password);
            users.add(user);
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        String query = "UPDATE users SET name = ?, email = ? WHERE pasword = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.executeUpdate();
    }

    public void deleteUser(int UserId) throws SQLException {
        String query = "DELETE FROM users WHERE userId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, UserId);
        preparedStatement.executeUpdate();
    }
}
