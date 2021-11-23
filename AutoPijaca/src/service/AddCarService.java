package service;

import dao.AddCarDao;
import dao.AdminDao;
import model.Car;
import model.User;
import model.UserDetails;

public class AddCarService {
	
	AddCarDao dao = new AddCarDao();
	AdminDao adminDao = new AdminDao();
	
	public User vratiUsera(String idUser) {
		return adminDao.vratiUseraPoId(idUser);
	}

	public UserDetails vratiUserDetails(User user) {
		return adminDao.vratiUserDetailsPoUser(user);
	}

	public Boolean daLiJeRegistrovan(String isRegisterFromForm) {
		return dao.daLiJeRegistrovan(isRegisterFromForm);
	}

	public Car fillCar(String manufacturer, String model, Double price, String year, Boolean isRegister,
			UserDetails details) {
		return dao.fillCar(manufacturer, model, price, year, isRegister,details);
	}

	public boolean ubaciCar(Car car) {
		return dao.ubaciCar(car);
	}

	public boolean spojiUserDetailsIcar(UserDetails details, Car car) {
		return dao.spojiUserDetailsIcar(details, car);
	}

}
