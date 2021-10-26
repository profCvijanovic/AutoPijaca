package common;

import model.User;
import model.UserType;

public class CommonMethods {

	public User popuniUsera(String userName, String password, String tipUsera) {
		
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		if(tipUsera.equals("0")) {
			user.setUserType(UserType.BUYER);
		}else {
			user.setUserType(UserType.SELLER);
		}
		
		return user;
	}

	public void ispisiParametre(String userName, String password) {
		System.out.println("Login parametri: ");
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
	}

}
