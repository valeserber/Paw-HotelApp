package ar.edu.itba.it.paw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.UserManager;

public class Login extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserManager um;
	
	@Override
	public void init() throws ServletException { 
		super.init();
		um= UserManager.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Boolean aux;
		if((aux=(Boolean) session.getAttribute("authentication"))==null){
			session.setAttribute("authentication", true);
		}
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String user= req.getParameter("user");
		String pass= req.getParameter("pass");
		HttpSession session = req.getSession();
		if(um.isRegistered(user, pass)){
			session.setAttribute("username",user);
			session.setAttribute("authentication", true);
			resp.sendRedirect("/HotelApp/listHotels");	
		}
		else{
			System.out.println("datos incorrectos");
			session.setAttribute("authentication", false);
			resp.sendRedirect("/HotelApp/login");	
		}
	}
}
