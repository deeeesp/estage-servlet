<%@ page import="ru.stazaev.entity.Worker" %>
<%--
  Created by IntelliJ IDEA.
  User: avast
  Date: 26.12.2022
  Time: 17:17
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
    <% Worker worker = (Worker) request.getAttribute("worker"); %>
    <input type="hidden" value="<%= worker.getId() %>" name="id" />
    <label>Name</label><br>
    <input name="name" value="<%= worker.getName() %>" /><br><br>
    <label>Number</label><br>
    <input name="number" value="<%= worker.getTelephone() %>" type="number" min="100" /><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>