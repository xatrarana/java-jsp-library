<%--
  Created by IntelliJ IDEA.
  User: xatra
  Date: 19-07-2023
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
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
    <div class="title my-4 mb-[-70px] h-[20vh] w-full relative">
        <h1 class="text-white font-bold text-5xl absolute left-10 top-5">Books</h1>
        <div class="buttons_items absolute right-10 top-5">
            <button class="bg-white py-4 px-7 rounded-md text-md font-bold"><a href="/cart">My Cart</a></button>

        </div>
    </div>
    <div class="upper-cor z-10 w-[30%]">
        <form method="get" class="flex flex-col gap-y-3 items-center justify-center" action="/search">
            <input class="h-12 rounded-md pl-5 text-xl w-full" type="text" name="q" />
            <button type="submit" class="px-12 py-2 rounded-md bg-blue-300 text-white text-2xl">search</button>
        </form>
    </div>
    <div class="inputcontainer w-full h-full rounded-md mt-5  flex flex-wrap justify-start p-3 gap-x-5 overflow-y-scroll ">
        <%-- Retrieve the books from the request attribute --%>
        <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
        <% if (books != null && !books.isEmpty()) { %>
        <% int index = 1; %>
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
                <button id="add-to-cart-btn" class="px-3 py-2 rounded-xl bg-white text-black text-xl font-semibold">
                    Add to cart
                </button>
            </div>
        </div>
            <% index++; %>
            <% } %>
            <% } else { %>
            <div>
                <h2>No Books Found.</h2>
            </div>
            <% } %>
    </div>
</div>

<script>
    function addToCart(event) {
        var button = event.target; // Get the clicked button element
        var bookContainer = button.closest(".book_contianer"); // Find the nearest ancestor with class "book_contianer"
        var bookId = bookContainer.getAttribute("data-book-id");
        console.log(bookId);
        alert(bookId);
        document.cookie = "bookId=" + bookId;
    }

    var addToCartButtons = document.querySelectorAll(".usr_action_btn button");
    addToCartButtons.forEach(function(button) {
        button.addEventListener("click", addToCart);
    });


</script>
</body>
</html>

