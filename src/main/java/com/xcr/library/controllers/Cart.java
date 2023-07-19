package com.xcr.library.controllers;

import com.xcr.library.DAO.Book;
import com.xcr.library.DAO.BookDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class Cart extends HttpServlet {
    private final BookDAO bookDAO;

    public  Cart() throws SQLException, ClassNotFoundException {
        this.bookDAO = new BookDAO();
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Book> cartItems = new ArrayList<>();

        // Retrieve the book IDs from the cookie
        List<Integer> bookIds = getBookIdsFromCookie(req);
        if (!bookIds.isEmpty()) {
            try {
                List<Book> books = bookDAO.getBookList(bookIds); // Fetch the list of books from the database based on the book IDs
                req.setAttribute("books", books); // Set the books as an attribute in the req
                RequestDispatcher dispatcher = req.getRequestDispatcher("/cart.jsp");
                dispatcher.forward(req, res); // Forward the req to the "cart.jsp" file
            } catch (SQLException e) {
                throw new RuntimeException("Failed to retrieve books", e);
            }
        } else {
            // Handle case when no book IDs are present in the cookie
            // For example, you could redirect the user to a "Cart is Empty" page
            res.sendRedirect("/cart-empty.jsp");
        }
    }


    private List<Integer> getBookIdsFromCookie(HttpServletRequest request) {
        List<Integer> bookIds = new ArrayList<>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("bookId")) {
                    String bookIdsString = cookie.getValue();
                    String[] bookIdsArray = bookIdsString.split(",");
                    for (String bookIdStr : bookIdsArray) {
                        try {
                            int bookId = Integer.parseInt(bookIdStr);
                            bookIds.add(bookId);
                        } catch (NumberFormatException e) {
                            // Handle invalid book IDs if needed
                        }
                    }
                }
            }
        }
        return bookIds;
    }

}

