package org.light.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberAreaController
 */
@WebServlet("/MemberAreaController")
public class MemberAreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberAreaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");

	switch(action) {
	case "destroy":
		request.getSession().invalidate();//this will destroy the session but generate another 
		System.out.println("Case destroy");
		response.sendRedirect(request.getContextPath()+"/WebControllerServlet?action=login");
		break;
	case "memberList":
	
		request.getRequestDispatcher("memberList.jsp").forward(request, response);
		break;
	case "membersOnly":
		request.getRequestDispatcher("membersOnly.jsp").forward(request, response);
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

	}

}
