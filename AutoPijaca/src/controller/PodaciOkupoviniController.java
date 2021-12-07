package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.User;
import model.UserDetails;
import service.ChosenCarsService;

/**
 * Servlet implementation class PodaciOkupoviniController
 */
@WebServlet("/PodaciOkupoviniController")
public class PodaciOkupoviniController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ChosenCarsService servis = new ChosenCarsService();
		
		String idCar = request.getParameter("idCar");
		String idUser = request.getParameter("idUser");
		
		System.out.println("id car:" + idCar);
		System.out.println("id user:" + idUser);
		
		Car car = servis.vratiCarPoId(idCar);
		User user = servis.vratiUseraPoId(idUser);
		UserDetails details = servis.vratiUserDetailsPoUser(user);
		
		request.setAttribute("car", car);
		request.setAttribute("details", details);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/podaciOkupovini.jsp");
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}

}
