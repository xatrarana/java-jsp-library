<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CompoundInterestXCR</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="maincontainer w-full h-[100vh] bg-black flex flex-col items-center justify-around p-3  ">
    <div class="title">
        <h1 class="text-white font-bold text-5xl">Add Book</h1>
    </div>
    <div class="inputcontainer w-[50%] h-[70%] bg-blue-300 flex items-center justify-center rounded-md ">
        <form action="/addbooks" method="post">

            <div class="flex flex-col gap-7 items-center justify-around">
                

                <div class="input_wrapper">
                    <input class="input_box w-[25vw] h-12 text-xl rounded-md pl-3 focus:border-green-700 focus:border-[2px] outline-none" type="text" name="title" placeholder="Book Title" />
                </div>
                <div class="input_wrapper">
                    <input class="input_box focus:border-green-700 focus:border-[2px] w-[25vw] h-12 text-xl rounded-md pl-3 outline-none" type="text" name="author" placeholder="Author Name" />
                </div>
                <div class="input_wrapper">
                    <input class="input_box focus:border-green-700 focus:border-[2px] w-[25vw] h-12 text-xl pl-3 rounded-md outline-none" type="text" name="available" placeholder="Available: (yes or no)" />
                </div>

                <button type="submit" class="w-[25vw] rounded-md h-12 bg-white font-bold">Submit</button>



              

            </div>
        </form>

    </div>
</div>
</body>
</html>