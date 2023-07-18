package com.xcr.library.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_Book_DAO {
    private Connection connection;

    public  User_Book_DAO() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/xcr_assignment_java", "root", "2025" );
    }
    public int addBorrowInvoice(User_Book userBook) throws SQLException {
        String query = "INSERT INTO user_book (userId, bookId, startDate,endDate) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, userBook.getUserId());
        preparedStatement.setInt(2, userBook.getBookId());
        preparedStatement.setString(3, userBook.getStartDate());
        preparedStatement.setString(4, userBook.getEndDate());

        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            userBook.setId(id);
            return id;
        } else {
            return -1; // return -1 if no ID was generated
        }
    }
    public List<User_Book> getAllBorrowedInvoice() throws SQLException {
        List<User_Book> userBooks = new ArrayList<>();
        String query = "SELECT user_book.*, users.name, book.title from user_book join users on user_book.userId = users.userId join book on user_book.bookId  = book.bkId";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            int userId = resultSet.getInt("userId");
            int bookId = resultSet.getInt("bookId");
            String startDate = resultSet.getString("startDate");
            String name = resultSet.getString("name");
            String title = resultSet.getString("title");
            String endDate = resultSet.getString("endDate");
            User_Book userBook = new User_Book( id, userId, bookId, startDate, endDate, name, title);
            userBooks.add(userBook);
        }
        return userBooks;
    }
}
