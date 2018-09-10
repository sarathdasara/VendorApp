package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.model.User;
import com.app.service.IUserService;
import com.app.util.CodeUtil;
import com.app.util.CommUtil;

@Controller
public class UserController {
@Autowired
private IUserService service;
@Autowired
private CodeUtil cUtil;
@Autowired
private CommUtil common;
@RequestMapping(value="/showUser")
public String showUser(){
	return "UserRegister";
}
@RequestMapping(value="/insertuser",method=RequestMethod.POST)
public String saveUser(@ModelAttribute("user")User u,ModelMap map){
	
	//gen password
	String pwd=cUtil.genPwd();
	//setpwd to model Attribute
	u.setuPwd(pwd);
	//saved to db
	int id=service.saveUser(u);
	//send Email
	String message="welcome to user : "+u.getuName()
	                +",login Id is : "+u.getuEmail()
	                +", or : "+u.getuContact()
	                +", or"+u.getuPwd();
	                
		boolean flag=common.sendEmail(u.getuEmail(),"User created....", message);
			String msg="user "+u.getuId()+" Created Successfully...";
			if(flag) msg+="email also sent successfully ";
			else msg+="email sending failed";
			map.addAttribute("msg",msg);
			
	return "UserRegister";
}
}
