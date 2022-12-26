<%@ page import="ru.stazaev.entity.Flat" %><%--
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
    <% Flat flat = (Flat) request.getAttribute("flat"); %>
    id Работника: <input type="number" value="<%= flat.getWorker_id() %>" name="wid" />
    <br><br>
    Meters: <input type="number" value="<%= flat.getMeters() %>" name="meters" />
    <br><br>
    Floor: <input type="number" value="<%= flat.getFloor() %>" name="floor" />
    <br><br>
    Rooms: <input type="number" value="<%= flat.getRooms() %>" name="rooms" />
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>