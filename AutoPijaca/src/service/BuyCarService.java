package service;

import dao.BuyCarDao;
import dao.ChosenCarsDao;
import model.Car;
import model.UserDetails;

public class BuyCarService {
	
	BuyCarDao dao = new BuyCarDao();
	ChosenCarsDao chosenCarsDao = new ChosenCarsDao();
	
	public Car vratiCarPoId(String idCar) {
		return chosenCarsDao.vratiCarPoId(idCar);
	}

	public UserDetails vratiUserDetailsPoId(String idBuyerUserDetails) {
		return dao.vratiUserDetailsPoId(idBuyerUserDetails);
	}

	public void prebaciAutomobilSaProdavcaNaKupca(Car car, UserDetails prodavac, UserDetails kupac) {
		dao.prebaciAutomobilSaProdavcaNaKupca(car, prodavac, kupac);
	}

	public void sacuvajTransakciju(Car car, UserDetails prodavac, UserDetails kupac) {
		dao.sacuvajTransakciju(car, prodavac, kupac);
		
	}
	
	

}
