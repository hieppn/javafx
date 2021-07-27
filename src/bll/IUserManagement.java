package bll;

import java.util.List;

import dto.UserDto;
import model.User;

public interface IUserManagement {
	
	public boolean checkLogin(String username, String password);
	public boolean checkLeader(String username, String password);
	public boolean checkMember(String username, String password);
	public boolean checkAdmin(String username, String password);
	public UserDto getUserById(Integer id);
	public String checkLogin1 (String username, String password) ;
	public User getUserByUsername(String username);

	public List<UserDto> getAllUsers();

	public void insertUser(UserDto user);

	public void deleteUser(String username);

	public void updateUser(UserDto user);
	
	public UserDto getUserByUserAndPass(String username, String password);
	public List<UserDto> search(UserDto user);

}
