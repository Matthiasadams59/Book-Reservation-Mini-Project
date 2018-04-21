package lab.mvc.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab.mvc.model.User;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet(description = "Mini Project", urlPatterns = {"/AuthServlet"})
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String userId, password;
		
		userId = request.getParameter("userId");
		password = request.getParameter("password");
		
		if (userId == null && password == null) {
            HttpSession session=request.getSession();  
            session.invalidate();  
            
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/goodbye.jsp");
			dispatcher.include(request, response);
			return;
		}
		
		Authentification loginService = new Authentification();
		boolean result = loginService.authenticate(userId, password);
		
		if (result) {
			User user = loginService.getUserDetails(userId);
			//request.setAttribute("user", user);

			request.getSession().setAttribute("user", user);
			//response.sendRedirect("welcome.jsp");
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/welcome.jsp");
			dispatcher.include(request, response);
			return;
		} else {
			//response.sendRedirect("error.jsp");
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/error.jsp");
			dispatcher.include(request, response);
			return;
		}
		
	}

}
