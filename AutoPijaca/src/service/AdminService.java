package service;

import java.util.List;

import common.CommonMethods;
import dao.AdminDao;
import model.User;
import model.UserType;

public class AdminService {
	
	AdminDao dao = new AdminDao();
	CommonMethods common = new CommonMethods();
	
	public UserType vratiUserType(String userType) {
		return common.vratiUserType(userType);
	}

	public List<User> vratiUserePoTipu(UserType type) {
		return dao.vratiUserePoTipu(type);
	}
	
	

}
