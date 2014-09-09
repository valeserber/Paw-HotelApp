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
		
		/*PrintWriter out=resp.getWriter();
		out.println("<html><body>");*/
		
		/*String data=req.getParameter("authentication");
		if(data!=null){
			if(data.equals("false")){
				out.println("<strong>Los datos ingresados son incorrectos</strong><br>");
			}
		}*/
		HttpSession session = req.getSession();
		Boolean aux;
		if((aux=(Boolean) session.getAttribute("authentication"))==null){
			session.setAttribute("authentication", true);
		}
		req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
		
		/*out.println("<h1>Ingrese al sitio</h1><br>");
		out.println("<br><form action=\"/HotelApp/login\" method=\"POST\">");
		out.println("Usuario: ");
		out.println("<input type=\"text\" name=\"user\"><br>");
		out.println("Contrasenia: ");
		out.println("<input type=\"password\" name=\"pass\"><br>");
		out.println("<input type=\"submit\" value=\"Ingresar\" >");
		out.println("</form><br>");
		out.println("<a href=\"/HotelApp/register\" method=\"GET\">Registrese aqui</a>");
		out.println("</body></html>");*/
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
			//resp.sendRedirect("/HotelApp/login?authentication=false");	
			resp.sendRedirect("/HotelApp/login");	
		}
	}
}
