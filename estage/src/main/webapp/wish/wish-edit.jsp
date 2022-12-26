<%@ page import="ru.stazaev.entity.Wish" %><%--
  Created by IntelliJ IDEA.
  User: avast
  Date: 26.12.2022
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit product</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">
    <% Wish wish = (Wish) request.getAttribute("wish"); %>
    id Работника: <input type="number" value="<%= wish.getId_client() %>" name="wid" />
    <br><br>
    Meters: <input type="number" value="<%= wish.getMeters() %>" name="meters" />
    <br><br>
    Rooms: <input type="number" value="<%= wish.getRooms() %>" name="rooms" />
    <br><br>
    Cost: <input type="number" value="<%= wish.getCost() %>" name="floor" />
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>