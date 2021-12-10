package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.UserDetails;
import service.BuyCarService;

/**
 * Servlet implementation class BuyCarController
 */
@WebServlet("/BuyCarController")
public class BuyCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BuyCarService servis = new BuyCarService();
		
		String idCar = request.getParameter("idCar");
		String idBuyerUserDetails = request.getParameter("idBuyerUserDetails");
		
		System.out.println("car: " + idCar);
		System.out.println("userDetails: " + idBuyerUserDetails);
		
		// 1. Izvadi objekat Car i izvuci prodavca iz automobila i UserDetails
		Car car = servis.vratiCarPoId(idCar);
		UserDetails prodavac = servis.vratiUserDetailsPoId(car.getUserDetails().getIdUserDetails().toString());
		UserDetails kupac = servis.vratiUserDetailsPoId(idBuyerUserDetails);
		// 2. Proveri da li kupac ima dovoljno novca
		if(kupac.getBalance() >= car.getPrice()) {
			// 3a. Ako ima dovoljno novca prebaci auto na novog usera 
			// 3b. Regulisi balance
			servis.prebaciAutomobilSaProdavcaNaKupca(car,prodavac,kupac);
			// 4. Sacuvaj transakciju
			servis.sacuvajTransakciju(car,prodavac,kupac);
			//5.vrati se na pocetak
			response.sendRedirect("jsp/buyer.jsp");
		}else {
			response.sendRedirect("html_stranice/noBalanceForBuy.html");
		}
		
		
		
	}

}
