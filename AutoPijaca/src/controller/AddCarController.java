package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.User;
import model.UserDetails;
import service.AddCarService;

/**
 * Servlet implementation class AddCarController
 */
@WebServlet(description = "add car", urlPatterns = { "/AddCarController" })
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AddCarService servis = new AddCarService();
		
		String idUser = request.getParameter("idUser");
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String priceFromForm = request.getParameter("price");
		Double price = Double.parseDouble(priceFromForm);
		String year = request.getParameter("year");
		String isRegisterFromForm = request.getParameter("isRegister");	
		Boolean isRegister = servis.daLiJeRegistrovan(isRegisterFromForm);	
		
		User user = servis.vratiUsera(idUser);
		UserDetails details = servis.vratiUserDetails(user);
		Car car = servis.fillCar(manufacturer, model, price, year, isRegister, details );
		
		boolean ubaciCarUtabelu = servis.ubaciCar(car);
		
		if(ubaciCarUtabelu) {
			
			boolean spojiUserDetailsIcar = servis.spojiUserDetailsIcar(details, car);
			if(spojiUserDetailsIcar) {
				response.sendRedirect("jsp/seller.jsp");
			}else {
				response.sendRedirect("jsp/seller.jsp");
			}
			
		}else {
			response.sendRedirect("jsp/seller.jsp");
		}

	}

}
