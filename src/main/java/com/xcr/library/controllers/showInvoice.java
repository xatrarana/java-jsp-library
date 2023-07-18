package com.xcr.library.controllers;

import com.xcr.library.DAO.Book;
import com.xcr.library.DAO.BookDAO;
import com.xcr.library.DAO.User_Book;
import com.xcr.library.DAO.User_Book_DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/invoices")

public class showInvoice extends HttpServlet {
    private final User_Book_DAO userBookDao;

    public showInvoice() throws SQLException, ClassNotFoundException {
        this.userBookDao = new User_Book_DAO();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<User_Book> invoices = userBookDao.getAllBorrowedInvoice(); // Fetch the list of books from the database
            req.setAttribute("invoices", invoices); // Set the books as an attribute in the request
            RequestDispatcher dispatcher = req.getRequestDispatcher("/showBorrow.jsp");
            dispatcher.forward(req, res); // Forward the request to the "book.jsp" file
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve books", e);
        }
    }
}
