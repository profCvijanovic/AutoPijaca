package service;

import common.CommonMethods;
import dao.RegistracijaLoginDao;
import model.User;
import validacija.Validacija;

public class LoginService {
	
	CommonMethods common  = new CommonMethods();
	Validacija validacija = new Validacija();
	RegistracijaLoginDao dao = new RegistracijaLoginDao();
	

	public void ispisiParametre(String userName, String password) {
		common.ispisiParametre(userName, password);
	}


	public boolean validirajUseriPass(String userName, String password) {
		return validacija.validirajUseriPass(userName,password);
	}


	public User vratiUseraPoUserNameiPassword(String userName, String password) {
		return dao.vratiUseraPoUserNameiPassword(userName, password);
	}

}
