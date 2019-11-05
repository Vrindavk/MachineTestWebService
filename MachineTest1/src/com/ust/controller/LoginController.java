package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.ILogin;
import com.ust.model.Login;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LoginController {
	//Test
	@Autowired
	private ILogin dao;
	
	@RequestMapping(value="/logindetails",method = RequestMethod.GET)
	public List getUserDetails(){
		List list;
		System.out.println("Getting the details");
		list = dao.getAllDetails();
		return list;
	}	
	@RequestMapping(value="/logindetails/{searchstring}",method = RequestMethod.GET)
	public Login getUserDetails(@PathVariable("searchstring")String searchString){
		
		System.out.println("Getting single user details");
		Login login= (Login)dao.searchUserDetails(searchString);
		return login;
		
	}
	@RequestMapping(value="/searchById/{uId}",method = RequestMethod.GET)
	public Login getUserByID(@PathVariable("uId")int uId ){
		
		System.out.println("Getting single user details");
		Login login = (Login)dao.getUserById(uId);
		return login;
	}
	@RequestMapping(value="/insertuser",method = RequestMethod.POST)
	public void insertDetails(@RequestBody Login login){
			dao.insertUserDetails(login);
	}
	
	@RequestMapping(value="/updateuser",method = RequestMethod.PUT)
	public void updateDetails(@RequestBody Login login){
			dao.updateUserDetails(login);
	}

}
