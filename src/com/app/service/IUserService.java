package com.app.service;

import com.app.model.User;

public interface IUserService {
	public int saveUser(User u);
	 public User getEmailAndPwd(String uName,String uPwd);
}
