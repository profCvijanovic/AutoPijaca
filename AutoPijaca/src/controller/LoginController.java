package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserType;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "ovo je login", urlPatterns = { "/pathToLogin" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService servis = new LoginService();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		servis.ispisiParametre(userName, password);
		
		// validacija: user i pass moraju biti popunjeni
		boolean daLiSuUseriPassPrazni= servis.validirajUseriPass(userName, password);
		if(!daLiSuUseriPassPrazni) {
			response.sendRedirect("html_stranice/login_fail.html");
		}
		// pretrazi u bazi da li postoji user sa ovim username-om i password-om
		User user = servis.vratiUseraPoUserNameiPassword(userName, password);
		if(user == null) {
			response.sendRedirect("html_stranice/login_fail.html");
		}else {
			
			// otvori sesiju
			HttpSession session = request.getSession();
			// ubaci usera u sesiju
			session.setAttribute("user", user);
			// ako user postoji vrati usera i preusmeri ga na njegovu stranu
			if(user.getUserType().equals(UserType.BUYER)) {
				//prebaci ga na stranicu za kupca
				response.sendRedirect("jsp/buyer.jsp");
			}else if(user.getUserType().equals(UserType.SELLER)) {
				//prebaci ga na stranicu prodavac
				response.sendRedirect("jsp/seller.jsp");
			}else {
				// prebaci ga na admin stranu
				response.sendRedirect("jsp/admin.jsp");
			}
		}
		
		
		
	}

}
