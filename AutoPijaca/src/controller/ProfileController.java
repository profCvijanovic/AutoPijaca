package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDetails;
import service.EditProfileService;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet(description = "view profile", urlPatterns = { "/ProfileController" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EditProfileService servis = new EditProfileService();
		
		String idUser = request.getParameter("idUser");
		
		User user = servis.vratiUseraPoId(idUser);
		UserDetails details = servis.vratiUserDetailsPoUseru(user);
		
		if(details != null) {
			// prebacujem se na stranu profile.jsp, ali prenosim i User Details
			request.setAttribute("details", details);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/profile.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("html_stranice/noUserDetailsFound.html");
		}
		
		
	}

}
