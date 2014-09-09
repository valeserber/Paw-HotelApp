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
		/*hm.addHotel(new Hotel(123,"Sol","hay solcito todo el dia"));
		hm.addHotel(new Hotel(124,"Luna","solo vengan de noche"));
		hm.addHotel(new Hotel(125,"Estrellas","hay telescopios"));*/
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		/*
			resp.getWriter().append("<html><body><h1>Hoteles disponibles:</h1><br>");
			List<Hotel> hotellist= hm.getHotelList();
			PrintWriter out=resp.getWriter();
			for(Hotel h:hotellist){
				out.println("<br>"+h.getCode()+"<br><a href=\"/HotelApp/viewHotel?code="+h.getCode()+"\">"+h.getName()+"</a><br>"+h.getDescription()+"<br>");
			}
			out.println("<br><a href=\"/HotelApp/logout\">Log out</a>");
			out.println("</body></html>");
		*/
		List<Hotel> hotellist= hm.getHotelList();
		req.setAttribute("hotellist", hotellist);
		req.getRequestDispatcher("/WEB-INF/jsp/listhotels.jsp").forward(req, resp);
	} 
}

