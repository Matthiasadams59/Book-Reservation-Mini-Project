package lab.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab.mvc.model.Book;

/**
 * Servlet implementation class ResServlet
 */
@WebServlet("/ResServlet")
public class ResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		/*String bookName;
		
		bookName = request.getParameter("bookName");
		
		if (bookName != null && !bookName.trim().equals("")) {
			Reservation reservation = (Reservation) request.getAttribute("reservation");
			
			if (reservation != null && reservation.books.containsKey(bookName)) {
				reservation.books.put(bookName, false);
				request.setAttribute("reservation", reservation);
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/confirmation.jsp");
				dispatcher.include(request, response);
				return;
			}
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String bookName;
		String bookChosen;
		
		bookName = request.getParameter("bookName");
		bookChosen = request.getParameter("bookChosen");
		
		Reservation reservation;
		ArrayList<Book> searchResults = new ArrayList<Book>();
		
		//request.getSession().setAttribute("user", user);
		
		if (request.getSession().getAttribute("reservation") == null) {
			reservation = new Reservation();
		} else {
			reservation = (Reservation) request.getSession().getAttribute("reservation");
		}
		
		if (bookChosen != null && !bookChosen.trim().equals("")) {
			
			if (request.getSession().getAttribute("user") == null) {
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.include(request, response);
				return;
			}
			
			reservation.books.put(bookChosen, false);
			
			searchResults = reservation.bookSearch("");
			request.getSession().setAttribute("books", searchResults);

			request.getSession().setAttribute("reservation", reservation);
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/confirmation.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		searchResults = reservation.bookSearch(bookName);
		
		request.getSession().setAttribute("books", searchResults);
		request.getSession().setAttribute("reservation", reservation);
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/books.jsp");
		dispatcher.include(request, response);
		return;

	}

}
