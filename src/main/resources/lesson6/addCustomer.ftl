<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <style>
        .form{
            display: flex;
            justify-content: center;
            align-items: center;
        }

        label{
            display: block;
            text-align: center;
            font-size: 25px;
        }

        input:not(#button){
            /*width: 150%;*/
            width: 250px;
            height: 35px;
            text-indent: 5px;
            border-radius: 5px;
            font-size: 18px;
        }

        #button{
            margin-left: 90px;
            width: 80px;
            height: 25px;
            background-color: white;
            border-color: yellowgreen;
            border-radius: 5px;

            outline-style: none;
        }

    </style>
</head>
<body>
<p style="text-align: center; font-size: 40px; color: red" >ADD CUSTOMER</p>
<div class="form">
    <form action="" method="post">
        <label for="name">Name</label>
        <input type="text" placeholder="Enter name: " name="name" id="name"/>
        <br><br>
        <label for="surname">Surname</label>
        <input type="text" placeholder="Enter surname: " name="surname" id="surname"> <br><br>
        <label for="email">Email</label>
        <input type="text" placeholder="Enter email: " name="email" id="email"><br><br>
        <input type="submit" value="Save" id="button">
    </form>
</div>

</body>
</html>