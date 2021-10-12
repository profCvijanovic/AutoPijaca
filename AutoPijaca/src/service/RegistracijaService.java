package service;

import validacija.Validacija;

public class RegistracijaService {
	
	Validacija validacija = new Validacija();
	
	public void ispisiParametreServis(String userName, String password, 
			String repeatedPassword, String tipUsera) {
		
		validacija.ispisiParametre(userName, password, repeatedPassword, tipUsera);
		
	}

	public boolean daLiJePassDobar(String password) {
		return validacija.daLiJePassDobar(password);
	}

}
