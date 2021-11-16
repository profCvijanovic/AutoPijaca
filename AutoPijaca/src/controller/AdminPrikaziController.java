package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserType;
import service.AdminService;

/**
 * Servlet implementation class AdminPrikaziController
 */
@WebServlet(description = "prikazi usere", urlPatterns = { "/AdminPrikaziController" })
public class AdminPrikaziController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService servis = new AdminService();
		
		String userType = request.getParameter("userType");
		System.out.println("Parametar: " + userType);
		
		UserType type = servis.vratiUserType(userType);
		
		// daj sve usere po izabranom tipu
		List<User> users = servis.vratiUserePoTipu(type);
		
		if(users !=null && !users.isEmpty()) {
			// listu usera pakujem u request object
			request.setAttribute("users", users);
			// radim redirection postojeceg requesta na stranu prikaziUsere.jsp
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/prikaziUsere.jsp");
			// spakuj request u response
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("jsp/admin.jsp");
		}
		
	}

}
