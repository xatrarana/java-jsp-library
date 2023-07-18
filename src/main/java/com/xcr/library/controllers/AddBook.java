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


public class AddBook extends HttpServlet {

    BookDAO bookDAO = new BookDAO();

    public AddBook() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html");

        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String available = req.getParameter("available");

        boolean isAvailable;
        if (available != null && available.equalsIgnoreCase("yes")) {
            isAvailable = true;
        } else {
            isAvailable = false; // or change it to the default value you want
        }
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.isAvailable(isAvailable);

        try {
            int bookId =  bookDAO.addBook(book);
            if(bookId > 0){
                req.setAttribute("success", "Successfully added");
                //RequestDispatcher rd = req.getRequestDispatcher("/book.jsp");
                //rd.forward(req,res);
                res.sendRedirect(req.getContextPath() + "/books");
            }else{
                req.setAttribute("error", "Failed to upload");
                RequestDispatcher rd = req.getRequestDispatcher("/book.jsp");
                rd.forward(req,res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
