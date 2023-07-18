package com.xcr.library.controllers;

import com.xcr.library.DAO.Book;
import com.xcr.library.DAO.BookDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search")
public class SearchBook extends HttpServlet {
    private final BookDAO bookDAO;

    public  SearchBook() throws SQLException, ClassNotFoundException {
        this.bookDAO = new BookDAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int searchParameter = Integer.parseInt(req.getParameter("q"));
        try {
            List<Book> books = bookDAO.getBookById(searchParameter); // Fetch the list of books from the database
            req.setAttribute("books", books); // Set the books as an attribute in the request
            RequestDispatcher dispatcher = req.getRequestDispatcher("/book.jsp");
            dispatcher.forward(req, res); // Forward the request to the "book.jsp" file
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve books", e);
        }
    }


}
