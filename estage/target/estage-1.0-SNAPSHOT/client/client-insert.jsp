<%--
  Created by IntelliJ IDEA.
  User: avast
  Date: 26.12.2022
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Client insert</title>
</head>
<body>
<form action="/worker/insert" method="POST">
    Name: <input type="text" name="username" />
    <br><br>
    Number: <input type="number" name="number" />
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
