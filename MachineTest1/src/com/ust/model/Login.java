package com.ust.model;

public class Login {
	private Long id;
	private String username;
	private String password;
	private Long roleId;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(Long id, String username, String password, Long roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", password=" + password + ", roleId=" + roleId + "]";
	}
	


}
