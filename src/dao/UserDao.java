package dao;


import java.util.List;

import dto.UserDto;

public interface UserDao {
	public UserDto getPersonBySignUp(String username,String pass);
	public UserDto getPersonByLeader(String username,String Pass);
	public UserDto getPersonByMember(String username,String Pass);
	public UserDto getAdmin(String username,String Pass);
	public UserDto getUserById(Integer id);

	public UserDto getUserByUsername(String username);

	public List<UserDto> getAllUsers();

	public void insertUser(UserDto user);

	public void deleteUser(String username);

	public void updateUser(UserDto user);
	
	public UserDto getUserByUserAndPass(String username, String password);
	public List<UserDto> search(UserDto user);
	
}
