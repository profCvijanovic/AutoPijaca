package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import service.ChosenCarsService;

/**
 * Servlet implementation class ChosenCarsController
 */
@WebServlet("/ChosenCarsController")
public class ChosenCarsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ChosenCarsService servis = new ChosenCarsService();
		
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String priceFromForm = request.getParameter("priceFrom");
		String priceToForm = request.getParameter("priceTo");
		String yearFrom = request.getParameter("yearFrom");
		String yearTo = request.getParameter("yearTo");
		String registration = request.getParameter("registration");
		
		Double priceFrom = null;
		Double priceTo = null;
		
		if(priceFromForm != null && !priceFromForm.equals("")) {
			priceFrom = Double.parseDouble(priceFromForm);
		}
		
		if(priceToForm != null && !priceToForm.equals("")) {
			priceTo = Double.parseDouble(priceToForm);
		}

		Boolean isRegister = servis.pretvoriStringRegistracijuUBoolean(registration);
		
		List<Car> listaAutomobila = servis.getChosenCars(manufacturer, model, priceFrom, priceTo,
															yearFrom, yearTo, isRegister );
		
		
		if(listaAutomobila != null) {
			
			request.setAttribute("listaAutomobila", listaAutomobila);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/chosenCars.jsp");
			dispatcher.forward(request, response);

		}else {
			response.sendRedirect("jsp/buyer.jsp");
		}
		
		
		
	}

}
