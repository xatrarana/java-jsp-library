<%--
  Created by IntelliJ IDEA.
  User: xatra
  Date: 18-07-2023
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>borrow | library-management-xatra</title>
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
        <h1 class="text-white font-bold text-5xl">Borrow Invoice</h1>
    </div>
    <div class="inputcontainer w-[50%] h-[70%] bg-blue-300 flex items-center justify-center rounded-md ">
        <form action="/addinvoice" method="post">

            <div class="flex flex-col gap-7 items-center justify-around">


                <div class="input_wrapper">
                    <input class="input_box w-[25vw] h-12 text-xl rounded-md pl-3 focus:border-green-700 focus:border-[2px] outline-none" type="text" name="userid" placeholder="Enter user id" />
                </div>
                <div class="input_wrapper">
                    <input class="input_box focus:border-green-700 focus:border-[2px] w-[25vw] h-12 text-xl rounded-md pl-3 outline-none" type="text" name="bookid" placeholder="Enter book id" />
                </div>
                <div class="input_wrapper">
                    <input class="input_box focus:border-green-700 focus:border-[2px] w-[25vw] h-12 text-xl pl-3 rounded-md outline-none" type="date" name="startdate" placeholder="Taken Day" />
                </div>
                <div class="input_wrapper">
                    <input class="input_box focus:border-green-700 focus:border-[2px] w-[25vw] h-12 text-xl pl-3 rounded-md outline-none" type="date" name="enddate" placeholder="End Day" />
                </div>
                <p class="error-message text-red-600 text-xl h-4 flex items-center justify-center">
                    <%-- Retrieve the error message from the request attribute --%>
                    <% String errorMessage = (String) request.getAttribute("error"); %>
                    <%-- Check if error message exists --%>
                    <% if (errorMessage != null) { %>
                    <%= errorMessage %>
                    <% } %>
                </p>

                <button type="submit" class="w-[25vw] rounded-md h-12 bg-white font-bold">Submit</button>





            </div>
        </form>

    </div>
</div>
</body>
</html>
