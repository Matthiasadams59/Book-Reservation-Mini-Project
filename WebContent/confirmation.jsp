<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show whether the reservation is successful or not.</title>
</head>
<body>
<h3>Reservation was succesful!</h3>
<form action="AuthServlet" method="POST">
Log-out : <input type="submit" name="validate" /> 
</form>
<br>
<a href="books.jsp">Go back to books</a>
</body>
</html>