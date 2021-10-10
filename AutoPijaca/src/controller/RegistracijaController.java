package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistracijaController
 */
@WebServlet(description = "ovo je servlet za registraciju", urlPatterns = { "/pathToRegistracija" })
public class RegistracijaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistracijaController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dobrodosli u doGet metodu...");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		String tipUsera = request.getParameter("tipUsera");
		
		System.out.println("Parametri su: ");
		System.out.println("User name: " + userName);
		System.out.println("Password: " + password);
		System.out.println("Repeated Password: " + repeatedPassword);
		System.out.println("Tip Usera: " + tipUsera);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Dobrodosli u doPost metodu...");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		String tipUsera = request.getParameter("tipUsera");
		
		System.out.println("Parametri su: ");
		System.out.println("User name: " + userName);
		System.out.println("Password: " + password);
		System.out.println("Repeated Password: " + repeatedPassword);
		System.out.println("Tip Usera: " + tipUsera);
	}

}
