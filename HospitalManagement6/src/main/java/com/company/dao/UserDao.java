package com.company.dao;

public interface UserDao {

	public boolean isValidUser(String username, String password);

	public boolean addUser(User user) ;
	
	public boolean isValidAdmin(String name, String password);

	boolean isValidDate(String date, String time);
	
}
