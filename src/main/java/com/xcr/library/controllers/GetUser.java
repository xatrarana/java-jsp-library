package com.xcr.library.controllers;

import com.xcr.library.DAO.Book;
import com.xcr.library.DAO.User;
import com.xcr.library.DAO.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/users")
public class GetUser extends HttpServlet {
    private final UserDAO userDAO;

    public GetUser() throws SQLException, ClassNotFoundException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = userDAO.getAllUsers(); // Fetch the list of users from the database
            request.setAttribute("users", users); // Set the users as an attribute in the request
            request.getRequestDispatcher("/user.jsp").forward(request, response); // Forward the request to the "user.jsp" file
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve users", e);
        }
    }
}
