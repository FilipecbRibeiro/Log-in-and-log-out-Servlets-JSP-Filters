package org.light.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class WebControllerServlet
 */
@WebServlet("/WebControllerServlet") // url pattern is /WebcontrollerServlet
public class WebControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public WebControllerServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action= request.getParameter("action"); 
	
	switch(action) {
	case "login":
	
	request.getRequestDispatcher("login.jsp").forward(request , response);
	
		break;
	default:
		break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action) {
		case "loginSubmit":
		
			authenticate(request, response);
			break;
		default:
			break;
		}
	
	

	}
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username= request.getParameter("username");
		String password= request.getParameter("password");

		if(username.equals("Filipe")&& password.equals("Ribeiro")) {
			request.getSession().invalidate();
			HttpSession session = request.getSession(true);
			session.setMaxInactiveInterval(300);
			session.setAttribute("username", username);
		
			String encode = response.encodeUrl(request.getContextPath());
			//we use encode to prevent our id being empty if cookies are disable on the webbrowser
			
			response.sendRedirect(encode+"/MemberAreaController?action=memberList");
			
		}//NOTE; WHEN USE SENDREDIRECT OR FORWARD? WHEN WE HAVE THE URL BASED ON THE SERVLET THEN WE USE SENDREDIRECT 
		else {
			String encode = response.encodeUrl(request.getContextPath());
			response.sendRedirect(encode+ "/WebContollerServlet?action=login");
		}
	}

}
//