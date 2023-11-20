<%@ page import="common.UserData" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Update User</h2>

<%
   
UserData userData = (UserData) session.getAttribute("userData");
System.out.println("UserData in JSP: " + userData.getName());


    if (userData != null) {
%>
    <form action="<%= request.getContextPath() %>/update" method="post">
        <!-- Hidden field for user ID -->
        <input type="hidden" name="id" value="<%= userData.getId() %>">
        
        Username: <input type="text" name="name" value="<%= userData.getName() %>" required>
        <br>
        <br>
        Email: <input type="email" name="email" value="<%= userData.getEmail() %>" required>
        <br>
        <br>
        <input type="submit" value="Update">
    </form>
<%
    } else {
%>
    <p>Error: User data not found or not set in the session.</p>
<%
    }
%>


</body>
</html>