package ar.edu.itba.it.paw.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.model.User;
import ar.edu.itba.it.paw.model.UserManager;

public class AddComment extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HotelManager hm;
	private UserManager um;
	
	@Override
	public void init() throws ServletException { 
		super.init();
		hm= HotelManager.getInstance();
		um= UserManager.getInstance();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String comment= req.getParameter("comment");
		String code= req.getParameter("code");
		
		HttpSession session = req.getSession();
		String username= (String)session.getAttribute("username");
		
		//Si estoy en addComment, username es distinto de null, porque lo checkea el filtro
		hm.addComment(comment,code,username);
		//PREGUNTAR
		//req.getRequestDispatcher("viewHotel").forward(req,resp);
		resp.sendRedirect("/HotelApp/viewHotel?code="+code);	
	}
}
