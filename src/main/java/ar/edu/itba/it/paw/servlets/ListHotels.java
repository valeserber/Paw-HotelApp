package ar.edu.itba.it.paw.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.Hotel;
import ar.edu.itba.it.paw.model.HotelManager;

public class ListHotels extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HotelManager hm;
	
	@Override
	public void init() throws ServletException { 
		super.init();
		hm= HotelManager.getInstance();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Hotel> hotellist= hm.getHotelList();
		req.setAttribute("hotellist", hotellist);
		req.getRequestDispatcher("/WEB-INF/jsp/listhotels.jsp").forward(req, resp);
	} 
}

