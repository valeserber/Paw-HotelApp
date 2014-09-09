package ar.edu.itba.it.paw.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ar.edu.itba.it.paw.model.UserManager;

public class Register extends HttpServlet{

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
					out.println("<strong>Ese usuario ya existe</strong><br>");
				}
			}*/
			
			HttpSession session = req.getSession();
			Boolean aux=(Boolean) session.getAttribute("authentication");
			if(aux==null){
				aux=true;
			}	
			session.setAttribute("authentication", aux);
			
			req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
			
			/*out.println("<h1>Registro</h1><br>");
			out.println("<br><form action=\"/HotelApp/register\" method=\"POST\">");
			out.println("Usuario: ");
			out.println("<input type=\"text\" name=\"user\"><br>");
			out.println("Contrasenia: ");
			out.println("<input type=\"password\" name=\"pass\"><br>");
			out.println("Email: ");
			out.println("<input type=\"text\" name=\"email\"><br>");
			out.println("<input type=\"submit\" value=\"Enviar\" >");
			out.println("</form><br>");
			out.println("</body></html>");*/
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String user= req.getParameter("user");
			String pass= req.getParameter("pass");
			String email= req.getParameter("email");
			HttpSession session = req.getSession();
			if(um.exists(user)){
				//resp.sendRedirect("/HotelApp/register?authentication=false");	
				resp.sendRedirect("/HotelApp/register");	
				session.setAttribute("authentication", false);
			}
			else{
				um.addUser(user,email,pass);
				session.setAttribute("username",user);
				session.setAttribute("authentication", true);
				resp.sendRedirect("/HotelApp/listHotels");	
			}
		}
}


