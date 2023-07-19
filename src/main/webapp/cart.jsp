<%@page import="com.xcr.library.DAO.Book"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CompoundInterest</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="maincontainer w-full h-[100vh] bg-black flex flex-col items-center justify-center  p-3  ">
    <div class="title my-4">
        <h1 class="text-white font-bold text-5xl">Cart</h1>
    </div>
    <div class="inputcontainer w-full h-full rounded-md relative ">
        <%-- Retrieve the books from the request attribute --%>
        <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
        <% if (books != null && !books.isEmpty()) { %>
        <div class="cart-items mt-5 flex flex-wrap justify-start p-3 gap-x-5 overflow-y-scroll">
            <% double totalAmount = 0.0; %>
            <% for (Book book : books) { %>
            <div class="book_contianer border p-2 h-[50vh] mt-4 rounded-md shadow-xl " data-book-id="<%= book.getBookId() %>" >
                <div class="book_item rounded-md  w-[20vw] h-[30vh] bg-red-400">
                </div>
                <div class=" mt-2 pl-2">
                    <h1 class="text-xl font-bold text-white"><%= book.getTitle() %></h1>
                    <span class="text-md capitalize text-white"><%= book.isAvailable() ? "available" : "not available" %></span>
                </div>
                <div class="usr_action_btn flex mt-1 items-center justify-between ">
                    <p class="font-bold text-white">Price: <%= book.getPrice() %></p>
                    <button class="px-3 py-2 rounded-xl bg-white text-black text-xl font-semibold add-to-cart-btn">
                        Add to cart
                    </button>
                </div>
            </div>
            <% totalAmount += book.getPrice(); %>
            <% } %>
        </div>
        <% if (totalAmount > 0) { %>
        <div class="total-amount-container absolute bottom-2 right-10">
            <p class="font-bold text-white">Total Amount: <%= totalAmount %></p>
            <button class="checkout-btn px-3 py-2 mt-2 rounded-xl bg-blue-300 text-white text-xl font-semibold">
                Checkout
            </button>
        </div>
        <% } %>
        <% } else { %>
        <div>
            <h2>Your cart is empty.</h2>
        </div>
        <% } %>
    </div>
</div>
</body>
</html>
