package com.app.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;
@Service
public class UserServiceimpl implements IUserService {
@Autowired
private IUserDao dao;
	public int saveUser(User u) {
		return dao.saveUser(u);
	}

	public User getEmailAndPwd(String uName, String uPwd) {
		return null;
	}

}
