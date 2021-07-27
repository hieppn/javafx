package bll;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.UserDto;

public class sign_upUser implements Sign_up {
	UserDao userdao=new UserDaoImpl() ;
		
	public boolean checkLogin(String username, String password) {
		// TODO Auto-generated method stub
		UserDto user = userdao.getPersonBySignUp(username, password);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}
 
}

