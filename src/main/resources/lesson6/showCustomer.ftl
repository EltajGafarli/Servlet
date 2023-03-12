<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Customers</title>

    <style>

        #button{
            margin-top: 10px;
        }
        #button a{
            font-size: 20px;
            color: darkgreen;
            border: 4px solid yellowgreen;
            padding: 4px;

            border-radius: 5px;
        }

        table{
            width: 100%;
            font-size: 25px;
        }

        tbody{
            background-color: yellowgreen;
        }

        #search input{
            height: 25px;
            text-indent: 3px;
        }
        #search #sbutton{
            outline-style: none;
            background-color: white;
            border-radius: 5px;
            border: 1px solid black;
            text-align: center;
        }

    </style>

</head>
<body>

    <div style="text-align: center; color: red; font-size: 40px; font-weight: bolder">Customers</div>
    <div>
        <div style="display: flex; justify-content: space-between">
            <p>${count}</p>
            <form method="get" id="search">
                <input  type="text" placeholder="Search..." name="searchName"/><input type="submit" value="search" id="sbutton"/>
            </form>
        </div>
        <table border="4">
            <thead>
               <th><a href="?sort=name">Name</a></th>
               <th><a href="?sort=surname">Surname</a></th>
               <th><a href="?sort=email">Email</a></th>
               <th>Action</th>
            </thead>

            <#list customers as customer>
            <tbody>
            <td style="text-align: center">${customer.name}</td>
            <td style="text-align: center">${customer.surname}</td>
            <td style="text-align: center">${customer.email}</td>
            <td style="text-align: center">
                <a href="/update?id=${customer.id}" style="text-align: center">Update</a> |
                <a href="/delete?id=${customer.id}" style="text-align: center">Delete</a>
            </td>
            </tbody>
            </#list>
        </table>

        <div style="display: flex; justify-content: flex-end" id="button"><a href="/addCustomer" style="text-decoration: none">Add Customer</a></div>
    </div>


</body>
</html>