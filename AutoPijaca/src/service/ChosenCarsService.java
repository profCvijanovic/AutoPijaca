package service;

import java.util.List;

import dao.ChosenCarsDao;
import model.Car;

public class ChosenCarsService {
	
	ChosenCarsDao dao = new ChosenCarsDao();

	public Boolean pretvoriStringRegistracijuUBoolean(String registration) {
		return dao.pretvoriStringRegistracijuUBoolean(registration);
	}

	public List<Car> getChosenCars(String manufacturer, String model, Double priceFrom, Double priceTo, String yearFrom,
			String yearTo, Boolean isRegister) {
		
		return dao.getChosenCars(manufacturer, model, priceFrom, priceTo, yearFrom,
				yearTo, isRegister);
	}

}
