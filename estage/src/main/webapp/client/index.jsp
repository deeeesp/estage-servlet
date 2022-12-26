<%@ page import="ru.stazaev.entity.Worker" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.stazaev.entity.Client" %><%--
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
<p><a href="/worker/worker-insert.jsp">Create new</a></p>
<table>
  <thead>
  <tr>
    <td>id</td>
    <td>fio</td>
    <td>email</td>
    <td>group_id</td>
  </tr>
  </thead>
  <tbody>
  <% List<Client> clients = (List<Client>) request.getAttribute("clients"); %>
  <% for (Client client : clients) {%>
  <tr>
    <td><%= client.getId() %></td>
    <td><%= client.getName() %></td>
    <td><%= client.getTelephone()%></td>
    <td>
      <a href='/client/update?id=<%= client.getId() %>'>Update</a> |
      <form method="get" action='/client/delete' style="display:inline;">
        <input type="hidden" name="id" value="<%= client.getId()%>">
        <input type="submit" value="Delete">
      </form>
    </td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>
