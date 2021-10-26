package service;

import common.CommonMethods;
import dao.RegistracijaLoginDao;
import model.User;
import validacija.Validacija;

public class RegistracijaService {
	
	Validacija validacija = new Validacija();
	CommonMethods common = new CommonMethods();
	RegistracijaLoginDao dao = new RegistracijaLoginDao();
	
	public void ispisiParametreServis(String userName, String password, 
			String repeatedPassword, String tipUsera) {
		
		validacija.ispisiParametre(userName, password, repeatedPassword, tipUsera);
		
	}

	public boolean daLiJePassDobar(String password) {
		return validacija.daLiJePassDobar(password);
	}

	public User popuniUsera(String userName, String password, String tipUsera) {	
		return common.popuniUsera(userName, password, tipUsera);
	}

	public boolean upisiUsera(User user) {
		return dao.upisiUsera(user);
	}

}
