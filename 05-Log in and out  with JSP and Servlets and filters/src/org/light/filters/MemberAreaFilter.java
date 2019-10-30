package org.light.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class MemberAreaFilter
 */
@WebFilter("/MemberAreaController")
/*
 * FIRST TASK: // we want to use this filter in the servet that we want so we
 * will call in this case the servlet "MemberAreaController"
 */
public class MemberAreaFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public MemberAreaFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		/*
		 * SECONDE TASK IS---> type cast the request and the response object because we
		 * receive it as ServletRequest and we receive on the servlet
		 * adoGet(HttpServletRequest request, HttpServletResponse response)
		 *
		 */
		HttpServletResponse response = (HttpServletResponse)resp;
		HttpServletRequest  request = (HttpServletRequest)req;
		
		if(request.getSession().getAttribute("username")==null) {
			String encode= response.encodeUrl(request.getContextPath());
			response.sendRedirect(encode +"//WebControllerServlet?action=login");
		}else
		// pass the request along the filter chain
		chain.doFilter(request, response);

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
