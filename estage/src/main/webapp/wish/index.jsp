<%@ page import="ru.stazaev.entity.Worker" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.stazaev.entity.Wish" %><%--
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
  <% List<Wish> wishes = (List<Wish>) request.getAttribute("wishes"); %>
  <% for (Wish wish : wishes) {%>
  <tr>
    <td><%= wish.getId() %></td>
    <td><%= wish.getId_client() %></td>
    <td><%= wish.getMeters()%></td>
    <td><%= wish.getRooms()%></td>
    <td><%= wish.getCost()%></td>
    <td>
      <a href='/wish/update?id=<%= wish.getId() %>'>Update</a> |
      <form method="get" action='/wish/delete' style="display:inline;">
        <input type="hidden" name="id" value="<%= wish.getId()%>">
        <input type="submit" value="Delete">
      </form>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
