package com.xcr.library.controllers;

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

@WebServlet("/addinvoice")

public class AddInvoice extends HttpServlet {
    User_Book_DAO userBookDao = new User_Book_DAO();

    public AddInvoice() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        super.doPost(req, res);
        res.setContentType("text/html");
        int userId = Integer.parseInt(req.getParameter("userid"));
        int bookId = Integer.parseInt(req.getParameter("userid"));
        String startDate = req.getParameter("startdate");
        String endDate = req.getParameter("enddate");

        System.out.println(userId + bookId + startDate + endDate);
        User_Book userBook = new User_Book();
        userBook.setUserId(userId);
        userBook.setBookId(bookId);
        userBook.setStartDate(startDate);
        userBook.setEndDate(endDate);
        try {
            int invoiceId =  userBookDao.addBorrowInvoice(userBook);
            if(invoiceId > 0){
                req.setAttribute("success", "Successfully added");
                RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                rd.forward(req,res);
            }else{
                req.setAttribute("error", "Failed to upload");
                RequestDispatcher rd = req.getRequestDispatcher("/borrow.jsp");
                rd.include(req,res);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
