package com.xcr.library.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/xcr_assignment_java";
        String username = "root";
        String password = "2025" ;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(url, username, password );
    }

    public int addBook(Book book) throws SQLException {
        String query = "INSERT INTO book (bkId, title, author, isAvailable) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setInt(1, book.getBookId());
        preparedStatement.setString(2, book.getTitle());
        preparedStatement.setString(3, book.getAuthor());
        preparedStatement.setBoolean(4, book.isAvailable());

        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            book.setBookId(id);
            return id;
        } else {
            return -1; // return -1 if no ID was generated
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("bkId");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            boolean isAvailable = resultSet.getBoolean("isAvailable");
            Book book = new Book( id, title, author, isAvailable);
            books.add(book);
        }
        return books;
    }
    public List<Book> getBookById(int id) throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM book WHERE bkId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id); // Set the ID parameter in the prepared statement
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            int bookId = rs.getInt("bkId");
            String title = rs.getString("title");
            String author = rs.getString("author");
            boolean isAvailable = rs.getBoolean("isAvailable");
            Book book = new Book(bookId, title, author, isAvailable);
            books.add(book);
        }

        return books;
    }




    public void updateBook(Book book) throws SQLException {
        String query = "UPDATE book SET title = ?, author = ? WHERE bkId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setInt(3, book.getBookId());
        preparedStatement.executeUpdate();
    }

    public void deleteBook(int bookId) throws SQLException {
        String query = "DELETE FROM book WHERE bkId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, bookId);
        preparedStatement.executeUpdate();
    }
}
