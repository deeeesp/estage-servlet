<%@ page import="ru.stazaev.entity.Client" %><%--
  Created by IntelliJ IDEA.
  User: avast
  Date: 26.12.2022
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Client</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">
    <% Client client = (Client) request.getAttribute("client"); %>
    <input type="hidden" value="<%= client.getId() %>" name="id" />
    <label>Name</label><br>
    <input name="name" value="<%= client.getName() %>" /><br><br>
    <label>Number</label><br>
    <input name="number" value="<%= client.getTelephone() %>" type="number" min="100" /><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
