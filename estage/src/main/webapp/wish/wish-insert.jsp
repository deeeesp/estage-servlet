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
    <title>Wish insert</title>
</head>
<body>
<form action="/flat/insert" method="POST">
    id клиента: <input type="number" name="cid" />
    <br><br>
    Meters: <input type="number" name="meters" />
    <br><br>
    Floor: <input type="number" name="floor" />
    <br><br>
    Cost: <input type="number" name="cost" />
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
