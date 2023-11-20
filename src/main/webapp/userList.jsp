<%@page import="common.UserData"%>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>User List</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        <% 
            List<UserData> userList = (List<UserData>) request.getAttribute("userList");
            for (UserData user : userList) {
        %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getEmail() %></td>
                <td>
                    <a href="<%= request.getContextPath() %>/update?id=<%= user.getId() %>">Update</a>
                    <a href="<%= request.getContextPath() %>/delete?id=<%= user.getId() %>">Delete</a>
                </td>
            </tr>
        <% } %>
    </table>
</body>
</html>