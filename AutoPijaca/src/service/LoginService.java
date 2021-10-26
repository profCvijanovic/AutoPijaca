package service;

import common.CommonMethods;
import dao.RegistracijaLoginDao;
import validacija.Validacija;

public class LoginService {
	
	CommonMethods common  = new CommonMethods();
	Validacija validacija = new Validacija();
	RegistracijaLoginDao dao = new RegistracijaLoginDao();

	public void ispisiParametre(String userName, String password) {
		common.ispisiParametre(userName, password);
	}

}
