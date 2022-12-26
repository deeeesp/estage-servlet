<%@ page import="ru.stazaev.entity.Worker" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.stazaev.entity.Flat" %><%--
  Created by IntelliJ IDEA.
  User: avast
  Date: 26.12.2022
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Products</title>
</head>
<body>
<h2>Products List</h2>
<p><a href="/flat/flat-insert.jsp">Create new</a></p>
<table>
  <thead>
  <tr>
    <td>id</td>
    <td>worker id</td>
    <td>meters</td>
    <td>rooms</td>
    <td>floor</td>
  </tr>
  </thead>
  <tbody>
  <% List<Flat> flats = (List<Flat>) request.getAttribute("flats"); %>
  <% for (Flat flat : flats) {%>
  <tr>
    <td><%= flat.getId() %></td>
    <td><%= flat.getWorker_id() %></td>
    <td><%= flat.getMeters()%></td>
    <td><%= flat.getRooms()%></td>
    <td><%= flat.getFloor()%></td>
    <td>
      <a href='/flat/update?id=<%= flat.getId() %>'>Update</a> |
      <form method="get" action='/flat/delete' style="display:inline;">
        <input type="hidden" name="id" value="<%= flat.getId()%>">
        <input type="submit" value="Delete">
      </form>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
