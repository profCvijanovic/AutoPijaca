package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.RegistracijaService;

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
		// nakacio sam se na servis
		RegistracijaService servis = new RegistracijaService();
		
		// prihvatio parametre iz request-a
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String repeatedPassword = request.getParameter("repeatedPassword");
		String tipUsera = request.getParameter("tipUsera");
		
		// proveri da li su parametri null
		
		// zovem ispis parametara
		servis.ispisiParametreServis(userName, password, repeatedPassword, tipUsera);
		
		// proveri password da li je u redu.
		boolean daLiJePassOk = servis.daLiJePassDobar(password);
		
		if(daLiJePassOk) {
			// pitam da li su repeated i obican pass isti
			if(password.equals(repeatedPassword)) {
				//popunjavamo usera
				User user = servis.popuniUsera(userName, password, tipUsera);
				// sacuvaj usera u bazu
				boolean upisanUserUbazu = servis.upisiUsera(user);
				if(upisanUserUbazu) {
					// ako se upisao u bazu vrati ga na index
					response.sendRedirect("index.html");
				}else {
					// ako se nije upisao u bazu, ponovo na registraciju
					response.sendRedirect("html_stranice/registracija.html");
				}
				
			}else {
				// ako nisu isti pss i rep. pass
				response.sendRedirect("html_stranice/wrong_repeated_password.html");
			}
		}else {
			// ako nije ok pass,vrati clientu odgovor
			response.sendRedirect("html_stranice/wrong_password.html");
		}
	
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
