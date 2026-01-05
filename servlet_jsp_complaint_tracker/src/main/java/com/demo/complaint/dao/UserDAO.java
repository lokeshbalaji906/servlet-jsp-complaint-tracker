package com.demo.complaint.dao;

import com.demo.complaint.model.User;

public interface UserDAO {
	
	User login(String email, String password);
		
}
