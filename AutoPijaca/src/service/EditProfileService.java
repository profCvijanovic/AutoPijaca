package service;

import dao.AdminDao;
import dao.EditProfileDao;
import model.User;
import model.UserDetails;

public class EditProfileService {
	
	EditProfileDao dao = new EditProfileDao();
	AdminDao adminDao = new AdminDao();

	public User vratiUseraPoId(String idUser) {
		return adminDao.vratiUseraPoId(idUser);
	}

	public UserDetails vratiUserDetailsPoUseru(User user) {
		return adminDao.vratiUserDetailsPoUser(user);
	}

	public boolean editujUserDetails(String firstName, String lastName, String phone, 
			String email, String country,String city, String street, UserDetails details) {
		return dao.editujUserDetails(firstName, lastName, phone, email, country,
				city, street,  details);
	}

}
