package lab.mvc.controller;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter extends HttpServlet implements Filter {
	private static final long serialVersionUID = 1L;
	/**
     * @see Filter#init(FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws javax.servlet.ServletException { 
         // TODO Auto-generated method stub
    }

	/**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws java.io.IOException, javax.servlet.ServletException { 
         // TODO Auto-generated method stub
    		
        HttpServletRequest request = (HttpServletRequest) arg0;
        HttpServletResponse response = (HttpServletResponse) arg1;
        HttpSession session = request.getSession();
        
        String requestPath = request.getRequestURI();

        	if (needsAuthentication(requestPath) && session == null || needsAuthentication(requestPath) && session.getAttribute("user") == null) {
        		
        		response.sendRedirect(request.getContextPath() + "/index.jsp"); // No logged-in user found, so redirect to login page.
        		
        	} else {
        		arg2.doFilter(arg0, arg1);
        	}

    		
    }
	/**
	 * @see Servlet#destroy()
	 */
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
    //basic validation of pages that do not require authentication
    private boolean needsAuthentication(String url) {
        String[] AuthenticationUrls = { "welcome.jsp", "error.jsp", "goodbye.jsp", "confirmation.jsp" };
        for (String validUrl : AuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return true;
            }
        }
        return false;
    }


}
