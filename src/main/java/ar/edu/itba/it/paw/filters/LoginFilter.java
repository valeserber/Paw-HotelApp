package ar.edu.itba.it.paw.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String username= (String)session.getAttribute("username");
		if(username!=null){
			chain.doFilter(request, response);
		}
		else{
			request.getRequestDispatcher("/login").forward(request, response);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
