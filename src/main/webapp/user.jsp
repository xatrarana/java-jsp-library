
<%@page import="com.xcr.library.DAO.User"%>
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
                <h1 class="text-white font-bold text-5xl">Users</h1>
            </div>
                <div class="xcr_inputcontainer w-[90%] h-[100%] bg-blue-300  ">
                    <table class="mt-5">
                        <tr>
                            <th>user ID</th>
                            <th>Name</th>
                            <th>Email</th>


                        </tr>

                        <%-- Retrieve the books from the request attribute --%>
                        <% List<User> users = (List<User>) request.getAttribute("users"); %>
                        <% if (users != null && !users.isEmpty()) { %>
                        <% int index = 1; %>
                        <% for (User user : users) { %>
                        <tr>
                            <td><%= user.getUserId() %></td>
                            <td><%= user.getName() %></td>
                            <td><%= user.getEmail() %></td>

                        </tr>
                        <% index++; %>
                        <% } %>
                        <% } else { %>
                        <tr>
                            <td colspan="4">No users found</td>
                        </tr>
                        <% } %>
                    </table>
                   
                  
                </div>
        </div>
</body>
</html>