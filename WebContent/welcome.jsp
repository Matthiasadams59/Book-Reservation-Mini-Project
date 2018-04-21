<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="lab.mvc.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome!</title>
</head>
<body>
<h3>Login successful!</h3>

<%
User user = (User) request.getSession().getAttribute("user");
%>

<p>Hello <%=user.getUserId()%>! You can use the search bar to look for the books you need (don't put any words if you want a list of all the books) : </p>
<form action="ResServlet" method="POST">
	<br>Book Name : <input type="text" name="bookName" />
	<br><input type="submit" name="validate" />
</form>
<form action="AuthServlet" method="POST">
Log-out : <input type="submit" name="validate" /> 
</form>
</body>
</html>