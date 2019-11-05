package com.ust.dao;

import java.util.List;

import com.ust.model.Login;

public interface ILogin {
	public abstract List<Login> getAllDetails();
	public abstract Login searchUserDetails(String searchString);
	public abstract Login getUserById(int uId);
	
	//public abstract int disableUser(int uId);
	
	public abstract int insertUserDetails(Login login);
	
	public abstract int updateUserDetails(Login login);

}
