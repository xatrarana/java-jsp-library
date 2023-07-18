package com.xcr.library.controllers;

import com.xcr.library.DAO.User;
import com.xcr.library.DAO.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class AddUser extends HttpServlet {

    UserDAO userDao = new UserDAO();

    public AddUser() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");


        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        try {
            int userId =  userDao.addUser(user);
            if(userId > 0){
                req.setAttribute("success", "Successfully added");
                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                rd.forward(req,resp);
            }else{
                req.setAttribute("error", "Failed to upload");
                RequestDispatcher rd = req.getRequestDispatcher("/adduser.jsp");
                rd.forward(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
