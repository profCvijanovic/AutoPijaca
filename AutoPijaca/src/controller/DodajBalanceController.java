package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDetails;
import service.AdminService;

/**
 * Servlet implementation class DodajBalanceController
 */
@WebServlet("/DodajBalanceController")
public class DodajBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminService servis = new AdminService();
		
		String userName = request.getParameter("userName");
		String balanceFromForm = request.getParameter("balance");
		
		Double balance = Double.parseDouble(balanceFromForm);
		
		User userFromDb = servis.vratiUseraPoUserName(userName);
		
		if(userFromDb != null) {
			System.out.println("User: " + userFromDb.getUserName());
			// preuzimamo UserDetails Object
			UserDetails details = servis.vratiUserDetailsPoUser(userFromDb);
			if(details == null) {
				response.sendRedirect("html_stranice/noUserFound.html");
			}else {
				//update balance na UserDetails
				boolean updateBalance = servis.updateBalance(details,balance);
				if(updateBalance) {
					response.sendRedirect("jsp/admin.jsp");
				}else {
					response.sendRedirect("html_stranice/noBalanceAdded.html");
				}
			}
			
		}else {
			response.sendRedirect("html_stranice/noUserFound.html");
		}
		
		
	}

}
