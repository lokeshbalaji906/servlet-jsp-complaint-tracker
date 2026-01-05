package com.demo.complaint.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.complaint.model.User;
import com.demo.complaint.util.DBConnectionUtil;

public class UserDAOImpl implements UserDAO {

	private static final String LOGIN_SQL = "SELECT * FROM users WHERE email = ? AND password = ?";
	
	@Override
	public User login(String email, String password) {
		try(
				Connection conn = DBConnectionUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(LOGIN_SQL);
				) {
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				return user;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}