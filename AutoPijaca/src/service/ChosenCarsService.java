package service;

import java.util.List;

import dao.AdminDao;
import dao.ChosenCarsDao;
import model.Car;
import model.User;
import model.UserDetails;

public class ChosenCarsService {
	
	ChosenCarsDao dao = new ChosenCarsDao();
	AdminDao adminDao = new AdminDao();

	public Boolean pretvoriStringRegistracijuUBoolean(String registration) {
		return dao.pretvoriStringRegistracijuUBoolean(registration);
	}

	public List<Car> getChosenCars(String manufacturer, String model, Double priceFrom, Double priceTo, String yearFrom,
			String yearTo, Boolean isRegister) {
		
		return dao.getChosenCars(manufacturer, model, priceFrom, priceTo, yearFrom,
				yearTo, isRegister);
	}

	public Car vratiCarPoId(String idCar) {
		return dao.vratiCarPoId(idCar);
	}

	public User vratiUseraPoId(String idUser) {
		return adminDao.vratiUseraPoId(idUser);
	}

	public UserDetails vratiUserDetailsPoUser(User user) {
		return adminDao.vratiUserDetailsPoUser(user);
	}

}
