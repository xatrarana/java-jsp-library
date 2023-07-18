<%--
  Created by IntelliJ IDEA.
  User: xatra
  Date: 18-07-2023
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@page import="com.xcr.library.DAO.User_Book"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>users | xatra-library-management</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <style>
    table {
      border-collapse: collapse;
      width: 100%;
    }

    th, td {
      text-align: left;
      padding: 8px;
      border-bottom: 1px solid #ddd;
    }
  </style>
</head>
<body>
<div class="maincontainer w-full h-[100vh] bg-black flex flex-col items-center justify-center  p-3  ">
  <div class="title my-4">
    <h1 class="text-white font-bold text-5xl">Borrow invoices record</h1>
  </div>
  <div class="xcr_inputcontainer w-[90%] h-[100%] bg-blue-300  ">
    <table class="mt-5">
      <tr>
        <th>Invoice ID</th>
        <th>User ID</th>
        <th>Name</th>
        <th>title</th>
        <th>Book ID</th>

        <th>Date</th>
        <th>Return</th>



      </tr>

      <%-- Retrieve the books from the request attribute --%>
      <% List<User_Book> invoices = (List<User_Book>) request.getAttribute("invoices"); %>
      <% if (invoices != null && !invoices.isEmpty()) { %>
      <% int index = 1; %>
      <% for (User_Book invoice : invoices) { %>
      <tr>
        <td><%= invoice.getId() %></td>
        <td><%= invoice.getUserId() %></td>
        <td><%= invoice.getUserName() %></td>
        <td><%= invoice.getBookId() %></td>

        <td><%= invoice.getBookName() %></td>


        <td><%= invoice.getStartDate() %></td>
        <td><%= invoice.getEndDate() %></td>


      </tr>
      <% index++; %>
      <% } %>
      <% } else { %>
      <tr>
        <td colspan="4">No Invoice found</td>
      </tr>
      <% } %>
    </table>


  </div>
</div>
</body>
</html>
