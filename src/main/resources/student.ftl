<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student</title>
</head>
<body>
   <div>Student</div>

   <table border="2">
       <thead>
           <td>Name</td>
           <td>Surname</td>
           <td>Email</td>
       </thead>

   <#list student as item>
       <tbody>
       <td>${item.name}</td>
       <td>${item.surname}</td>
       <td>${item.email}</td>
       </tbody>
   </#list></table>


<#--    <#list map as item>-->
<#--        <div>FUN</div>-->
<#--    </#list>-->

</body>
</html>