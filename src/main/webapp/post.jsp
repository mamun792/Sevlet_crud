<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Post Data</h1>
 <form action="NewPost" method="post">
        Name: <input type="text" name="name" required>
        <br>
        <br>
        Email: <input type="email" name="email" required>
        <input type="submit" value="Insert">
    </form>
    
  <br>
  <br>
    <a href="read">Show All Data</a>
</body>
</html>