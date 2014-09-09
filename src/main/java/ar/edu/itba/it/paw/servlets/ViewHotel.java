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
		//PrintWriter out=resp.getWriter();
		
		if(hotel!=null){
			req.setAttribute("hotel", hotel);
			//List<Comment> commentlist=hotel.getComments();
			List<Comment> commentlist= hm.getComments(Integer.valueOf(code));
			req.setAttribute("commentlist",commentlist);
			req.getRequestDispatcher("/WEB-INF/jsp/viewhotel.jsp").forward(req, resp);
			
			/*out.println("<html><body><h1>Hotel "+hotel.getName()+"</h1><br>");
			out.println("<strong>Descripción: </strong>"+hotel.getDescription()+"<br>");
			out.println("<strong>Comentarios de usuarios: </strong><br>");
			for(Comment comment:hotel.getComments()){
				out.println("<strong>"+comment.getUser().getName()+" </strong>");
				out.println("("+comment.getUser().getEmail()+"): ");
				out.println(comment.getText()+"<br>");
			}*/
			
			/*out.println("<br><form action=\"/HotelApp/addComment\" method=\"POST\">");
			out.print("<input type=\"hidden\" name=\"code\" value="+code+">");
			out.println("Ingrese su comentario: ");
			out.println("<input type=\"text\" name=\"comment\"><br>");*/
			
			/*
			out.println("Ingrese su nombre: ");
			out.println("<input type=\"text\" name=\"name\"><br>");
			out.println("Ingrese su email: ");
			out.println("<input type=\"text\" name=\"email\"><br>");
			out.println("<input type=\"submit\" value=\"Enviar\" >");
			out.println("</form>");*/
		}
		else{
			//out.println("<html><body><h1>Ese hotel no existe!</h1><br>");
		}
		//out.println("<br><form action=\"/HotelApp/listHotels\" method=\"GET\">"
			//	+ "<input type=\"submit\" value=\"Volver\"></form>");
		//out.println("</body></html>");
	} 
}
