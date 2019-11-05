package com.ust.dao;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.List;

	import org.springframework.jdbc.core.BeanPropertyRowMapper;
	import org.springframework.jdbc.core.JdbcTemplate;
	import org.springframework.jdbc.core.RowMapper;

	import com.ust.model.Login;


	public class LoginDao implements ILogin {
		//setting Jdbc template
		
			JdbcTemplate template;
			
			public void setTemplate(JdbcTemplate template){
				this.template = template;
			}

		@Override
		public List<Login> getAllDetails() {
			// TODO Auto-generated method stub
			return template
					.query("select id,username,password,roleid from tbl_login order by id desc",
							new RowMapper<Login>(){

						@Override
						public Login mapRow(ResultSet rs, int row) throws SQLException {
							// TODO Auto-generated method stub
							Login login = new Login();
							login.setId(rs.getLong(1));
							login.setUsername(rs.getString(2));
							login.setPassword(rs.getString(3));
							login.setRoleId(rs.getLong(4));
							return login;
						}
						
					});
					
		}
		
	@Override
		public Login searchUserDetails(String searchString) {
			// TODO Auto-generated method stub
		String sql="select id,username,password,roleid from tbl_login where username=? ";
		return template.queryForObject(sql,new Object[] {searchString},
				new BeanPropertyRowMapper<Login>(Login.class));
		}

		@Override
		public Login getUserById(int uId) {
			// TODO Auto-generated method stub
			String sql="select id,username,password,roleid from tbl_login where id=? ";
			return template.queryForObject(sql,new Object[] {uId},
					new BeanPropertyRowMapper<Login>(Login.class));
		}

		@Override
		public int insertUserDetails(Login login) {
			// TODO Auto-generated method stub
			String sqlOne = "insert into tbl_login(username,password, "
					+ "roleid) values('"
					+ login.getUsername()
					+ "','"
					+ login.getPassword()
					+ "','"
					+ login.getRoleId()
					
					+ ")";
			
			return template.update(sqlOne);
		}

		@Override
		public int updateUserDetails(Login login) {
			// TODO Auto-generated method stub
			// to update user table
					String sqlOne = "update tbl_login set username='" +  login.getUsername()
							+ "',password='" + login.getPassword() + "',roleId='" + login.getRoleId()
							
							+ " where id=?";
					return template.update(sqlOne, new Object[] { login.getId() });
		}

}
