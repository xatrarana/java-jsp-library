package com.xcr.library.controllers;

import com.xcr.library.DAO.Book;
import com.xcr.library.DAO.BookDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetBooks extends HttpServlet {
    private final BookDAO bookDAO;

    public GetBooks() throws SQLException, ClassNotFoundException {
        this.bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Book> books = bookDAO.getAllBooks(); // Fetch the list of books from the database
            request.setAttribute("books", books); // Set the books as an attribute in the request
            RequestDispatcher dispatcher = request.getRequestDispatcher("/book.jsp");
            dispatcher.forward(request, response); // Forward the request to the "book.jsp" file
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve books", e);
        }
    }
}
