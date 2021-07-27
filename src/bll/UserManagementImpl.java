package bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import dto.UserDto;
import model.User;

public class UserManagementImpl implements IUserManagement {
	static List<UserDto> list1 = new ArrayList<>();

	UserDao userDao = new UserDaoImpl();
	UserDto userdto = new UserDto();

	@Override
	public boolean checkLogin(String username, String password) {
		UserDto userDto = userDao.getPersonBySignUp(username, password);
		if (userDto != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkLeader(String username, String position) {
		UserDto userDto = userDao.getPersonByLeader(username, position);
		if (userDto != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkMember(String username, String position) {
		UserDto userDto = userDao.getPersonByMember(username, position);
		if (userDto != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkAdmin(String username, String position) {
		UserDto userDto = userDao.getAdmin(username, position);
		if (userDto != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserDto getUserById(Integer id) {
		UserDao Persondao = new UserDaoImpl();
		UserDto userDto = Persondao.getUserById(id);
		if (userDto != null) {
			UserDto cus = new UserDto();
			cus.setId(userDto.getId());
			cus.setUsername(userDto.getUsername());
			cus.setFirstName(userDto.getFirstName());
			cus.setLastName(userDto.getLastName());
			cus.setEmail(userDto.getEmail());
			cus.setPosition(userDto.getPositin());
			cus.setGender(userDto.getGender());
			cus.setPassword(userDto.getPassword());
			cus.setBirthday(userDto.getBirthday());
			cus.setPhoneNumber(userDto.getPhoneNumber());
			cus.setAddress(userDto.getAddress());
			return userDto;
		}
		return null;
	}

	
	@Override
	public User getUserByUsername(String username) {
		UserDto user = userDao.getUserByUsername(username);
		UserDao Persondao = new UserDaoImpl();
		User users = new User();

		users.setId(user.getId());
		users.setUsername(user.getUsername());
		users.setFirstName(user.getFirstName());
		users.setLastName(user.getLastName());
		users.setEmail(user.getEmail());
		users.setPosition(user.getPositin());
		users.setGender(user.getGender());
		users.setPassword(user.getPassword());
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		users.setDateOfBirth(dateFormat.format(user.getBirthday()));
		users.setPhoneNumber(user.getPhoneNumber());
		users.setAddress(user.getAddress());
		return users;

	}

	@Override
	public List<UserDto> getAllUsers() {
		UserDao Persondao = new UserDaoImpl();
		List<UserDto> list = Persondao.getAllUsers();
		for (UserDto customer : list) {
			UserDto cus = new UserDto();
			cus.setId(customer.getId());
			cus.setUsername(customer.getUsername());
			cus.setFirstName(customer.getFirstName());
			cus.setLastName(customer.getLastName());
			cus.setEmail(customer.getEmail());
			cus.setPosition(customer.getPositin());
			cus.setGender(customer.getGender());
			cus.setPassword(customer.getPassword());
			cus.setBirthday(customer.getBirthday());
			cus.setPhoneNumber(customer.getPhoneNumber());
			cus.setAddress(customer.getAddress());
			list1.add(cus);
		}
		return list1;

	}

	@Override
	public void insertUser(UserDto user) {

		UserDto dto = new UserDto();
		if (user != null) {

			dto.setId(user.getId());
			dto.setFirstName(user.getFirstName());
			dto.setLastName(user.getLastName());
			dto.setEmail(user.getEmail());
			dto.setUsername(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setPosition(user.getPositin());
			dto.setGender(user.getGender());
			dto.setBirthday(user.getBirthday());
			dto.setPhoneNumber(user.getPhoneNumber());
			dto.setAddress(user.getAddress());

			userDao.insertUser(dto);
		}
	}

	@Override
	public void updateUser(UserDto user) {
		UserDto dto = new UserDto();
		if (user != null) {

			dto.setId(user.getId());
			dto.setFirstName(user.getFirstName());
			dto.setLastName(user.getLastName());
			dto.setEmail(user.getEmail());
			dto.setUsername(user.getUsername());
			dto.setPassword(user.getPassword());
			dto.setPosition(user.getPositin());
			dto.setGender(user.getGender());
			dto.setBirthday(user.getBirthday());
			dto.setPhoneNumber(user.getPhoneNumber());
			dto.setAddress(user.getAddress());

			userDao.updateUser(dto);
		}
	}

	@Override
	public void deleteUser(String username) {
		userDao.deleteUser(username);

	}

	@Override
	public UserDto getUserByUserAndPass(String username, String password) {
		UserDao Persondao = new UserDaoImpl();
		UserDto userDto = Persondao.getUserByUserAndPass(username, password);
		if (userDto != null) {
			UserDto cus = new UserDto();
			cus.setId(userDto.getId());
			cus.setUsername(userDto.getUsername());
			cus.setFirstName(userDto.getFirstName());
			cus.setLastName(userDto.getLastName());
			cus.setEmail(userDto.getEmail());
			cus.setPosition(userDto.getPositin());
			cus.setGender(userDto.getGender());
			cus.setPassword(userDto.getPassword());
			cus.setBirthday(userDto.getBirthday());
			cus.setPhoneNumber(userDto.getPhoneNumber());
			cus.setAddress(userDto.getAddress());
			return userDto;
		}
		return null;

	}

	@Override
	public List<UserDto> search(UserDto user) {
		UserDao Persondao = new UserDaoImpl();
		List<UserDto> list = Persondao.search(user);
		for (UserDto customer : list) {
			UserDto cus = new UserDto();
			cus.setId(customer.getId());
			cus.setUsername(customer.getUsername());
			cus.setFirstName(customer.getFirstName());
			cus.setLastName(customer.getLastName());
			cus.setEmail(customer.getEmail());
			cus.setPosition(customer.getPositin());
			cus.setGender(customer.getGender());
			cus.setPassword(customer.getPassword());
			cus.setBirthday(customer.getBirthday());
			cus.setPhoneNumber(customer.getPhoneNumber());
			cus.setAddress(customer.getAddress());
			list1.add(cus);
		}
		return list1;

	}

	public String checkLogin1(String name, String password) {
		UserDto userDto = userDao.getUserByUserAndPass(name, password);
		if (userDto != null) {
			return userDto.getUsername();
		} else {

			return null;
		}
	}

}
