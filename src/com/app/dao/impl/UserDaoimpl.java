package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;
@Repository
public class UserDaoimpl implements IUserDao{
	@Autowired
	private HibernateTemplate ht;
	public int saveUser(User u) {
		return (Integer) ht.save(u);
	}

	public User getEmailAndPwd(String uName, String uPwd) {
		return null;
	}

}
