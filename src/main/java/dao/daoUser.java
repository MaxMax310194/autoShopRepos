package dao;

import java.util.List;

import model.User;

public interface daoUser {

	public List<User> getAllUser();
	public void addUser(User user);
	public void delUser(User user);
	public void updateUser(User user);
	public User getUserByName(String name);
	public User getUserByNameAndPassword(String name,String password);
		
	
	
		
	
		
	
		
	
	
}
