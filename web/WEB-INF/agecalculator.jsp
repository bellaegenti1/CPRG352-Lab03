<%-- 
    Document   : newjsp
    Created on : 3-Oct-2021, 1:07:41 PM
    Author     : itsd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>calculate</title>
    </head>
    <body>
        <h1>Calculate Age</h1>
        <form method="POST" action="Age">
             <label>Enter current age:</label>
       
            <input type="text" name="current_age" value="${currentAge}">
            <br>
            <input type="submit" value="Age next birthday">
            <br>
        </form>
        <p> ${message}</p>
        <a href="arithmetic">Arithmetic Calculator</a>
    </body>
</html>
