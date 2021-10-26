package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// pretrazi u bazi da li postoji user sa ovim username-om i password-om
		// ako user postoji vrati usera i preusmeri ga na njegovu stranu
		
		
	}

}
