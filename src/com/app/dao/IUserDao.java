package com.app.dao;

import com.app.model.User;

public interface IUserDao {
	
 public int saveUser(User u);
 public User getEmailAndPwd(String uName,String uPwd);
}
