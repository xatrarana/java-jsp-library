<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | xatra-library-management</title>
     <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
        <div class="xcr_xatra_maincontainer w-full h-[100vh] bg-black flex flex-col flex-wrap items-center justify-center  p-3  ">
            <div class="title my-4">
                <h1 class="text-white font-bold text-5xl">Library Management</h1>
            </div>
                <div class="xcr_inputcontainer w-[90%] h-[80%] bg-blue-300 flex flex-col items-center justify-center rounded-md my-5 gap-16 flex-wrap ">



                    <div class="upper-cor  w-[30%]">
                        <form method="get" class="flex flex-col gap-y-3 items-center justify-center" action="/search">
                            <input class="h-12 rounded-md pl-5 text-xl w-full" type="text" name="q" />
                            <button type="submit" class="px-12 py-2 rounded-md bg-black text-white text-2xl">search</button>
                        </form>
                    </div>
                    <div class="lower-cor flex gap-x-4">
                        <div class="buttons_items">
                            <button class="bg-white py-4 px-7 rounded-md text-md font-bold"><a href="addbook.jsp">add book</a></button>

                        </div>
                        <div class="button_items">
                            <button class="bg-white py-4 px-7 rounded-md text-md font-bold"><a href="adduser.jsp">create user</a></button>

                        </div>
                        <div class="button_items">
                            <button class="bg-white py-4 px-7 rounded-md text-md font-bold"><a href="books">see books</a></button>
                        </div>
                        <div class="button_items">
                            <button class="bg-white py-4 px-7 rounded-md text-md font-bold"><a href="users">see users</a></button>

                        </div>
                        <div class="button_items">
                            <button class="bg-white py-4 px-7 rounded-md text-md font-bold"><a href="borrow.jsp">Add Borrow Invoice</a></button>

                        </div>
                        <div class="button_items">
                            <button class="bg-white py-4 px-7 rounded-md text-md font-bold"><a href="invoices">Show Invoice</a></button>

                        </div>
                    </div>


                  
                </div>
        </div>
</body>
</html>