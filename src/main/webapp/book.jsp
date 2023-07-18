

<%@page import="com.xcr.library.DAO.Book"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>books | xatra-library-management</title>
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
                <h1 class="text-white font-bold text-5xl">Books</h1>
            </div>
                <div class="inputcontainer w-[90%] h-[100%] bg-blue-300  ">
                    <table class="mt-5">
                        <tr>
                            <th>Book ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Available</th>
                            
                        </tr>

                        <%-- Retrieve the books from the request attribute --%>
                        <% List<Book> books = (List<Book>) request.getAttribute("books"); %>
                        <% if (books != null && !books.isEmpty()) { %>
                        <% int index = 1; %>
                        <% for (Book book : books) { %>
                        <tr>
                            <td><%= book.getBookId() %></td>
                            <td><%= book.getTitle() %></td>
                            <td><%= book.getAuthor() %></td>
                            <td><%= book.isAvailable() ? "Available" : "Not Available" %></td>
                        </tr>
                        <% index++; %>
                        <% } %>
                        <% } else { %>
                        <tr>
                            <td colspan="4">No books found</td>
                        </tr>
                        <% } %>
                    </table>
                   
                  
                </div>
        </div>
</body>
</html>