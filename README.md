# Book-Reservation-Mini-Project

II.2406 Web Technologies - Mini Project

##Objective

Handling a book reservation process using Servlets and JSPs

##Description
1. A client opens the index.jsp page, provides her username and password, then clicks on a Log-in button.
2. The client request is send to the AuthServlet for authentication.
3. The AuthServlet calls a Java class (or JavaBean)
named Authentication.java to check the received username/password?
4. If the authentication fails, the AuthServlet will open the error.jsp page.
Otherwise, it will open the welcome.jsp page.
5. At the welcome.jsp page, the client can search for a book by sending the request
to a ResServlet.
6. The ResServlet calls another Java class (or JavaBean)
named Reservation.java to search for book and displays the search results
using the books.jsp page.
7. In the books.jsp page, the client can either reserve a book or make another
search.
8. If the client reserves a book, the ResServlet will call
the Reservation.java class to update the reservation information and open the confirmation.jsp page to show whether the reservation is successful or not.
9. At the welcome.jsp, books.jsp and confirmation.jsp pages, if the client clicks on a Log-out button, the AuthServlet will open the goodbye.jsp page and terminate the session.


###Note that:
* welcome.jsp,error.jsp,goodbye.jspandconfirmation.jsppages
can be accessed only after authentication. If the client opens these pages without authentication, he will be redirected to the index.jsp page.
* The user can access the page books.jsp page to make a search for books. But when she reserves a book without loging in, the Servlet will redirect her to the index.jsp page.

## Deployment

Tomcat 9.0

## Built with 

Java EE

## Author

Ali Taïga Matthias-Adams
