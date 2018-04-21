<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="lab.mvc.model.Book, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display the search results</title>
</head>
<body>
<h3>Reserve a book</h3>
<%
ArrayList<Book> bookResults = (ArrayList<Book>) session.getAttribute("books");

if (bookResults == null || bookResults.isEmpty()) {
%>
<p>No results  found. Please retry another search.</p>
<%} else {
	%>
	<p>Results : </p>
	<table border="1">
		<tr>
			<td>Name</td>
			<td>Reservable</td>
		</tr>
		<% for (int i = 0 ; i < bookResults.size() ; i++) { %>
			<tr>
			<td><%=bookResults.get(i).getName()%></td>
			<%
			if (bookResults.get(i).getRented()) { %>
				<td>YES</td>
			<%} else { %>
				<td>NO</td>
			<%} %>
			</tr>			
		<%}
		%>
	</table>
	<form action="ResServlet" method="POST">
	<br>Name of the book you want to rent : <input type="text" name="bookChosen" />
	<br><input type="submit" name="validate2" />
	</form>
	<%
}%>
<h3>Make another search</h3>
<form action="ResServlet" method="POST">
	<br>Book Name : <input type="text" name="bookName" />
	<br><input type="submit" name="validate" />
</form>
<br>
<form action="AuthServlet" method="POST">
Log-out : <input type="submit" name="validate3" /> 
</form>
</body>
</html>