package ar.edu.itba.it.paw.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.Comment;
import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelManager;
import ar.edu.itba.it.paw.model.UserManager;

public class ViewHotel extends HttpServlet{

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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String user = (String)session.getAttribute("username");
		
		String code= req.getParameter("code"); //puede ser null
		Hotel hotel=hm.getHotel(code);
		
		if(hotel!=null){
			req.setAttribute("hotel", hotel);
			List<Comment> commentlist= hm.getComments(Integer.valueOf(code));
			req.setAttribute("commentlist",commentlist);
			req.getRequestDispatcher("/WEB-INF/jsp/viewhotel.jsp").forward(req, resp);
		}
		else{
			String message="Ese hotel no existe!";
			req.setAttribute("error", message);
			req.getRequestDispatcher("/WEB-INF/jsp/errorpage.jsp").forward(req, resp);
		}
	} 
}
