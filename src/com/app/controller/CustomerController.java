package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.charts.CstomerPieChart;
import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommUtil;

@Controller
public class CustomerController {
	@Autowired
	private ICustomerService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private CstomerPieChart util;
	@Autowired
	private CodecUtil codec;
	@Autowired
	private CodeUtil code;
	@Autowired
	private CommUtil common;
	int cust=0;
	int custId=0;
	String text=null;
	String pwd=null;
	String token=null;
	String encPwd=null;
	String encToken=null;
	String message=null;
	@RequestMapping("/regCustomer")
	public String showPage(){
		return "CustomRegister";
	}
	@RequestMapping(value="/insertCustomer",method=RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer")Customer c,ModelMap map) {
		
		//generate PWD,TOKEN
				String pwd=code.genPwd();
				String token=code.genToken();
			
				//encode pwd,token
				String encPwd=codec.doEncode(pwd);
				String encToken=codec.doEncode(token);
				
				//set encoded pwd,token to cust model object
				c.setcPwd(encPwd);
				c.setToken(encToken);
				
				//save cust object
				int custId=service.saveCustomer(c);
				
				//send email
				String text="Welcome to Customer : " +c.getcName()
						+" , your ID is  : "+c.getcEmail()
						+" , password is : "+pwd
						+" , Token is    : "+token
						+" , Type is     : "+c.getcType();
				
				boolean flag=common.sendEmail(c.getcEmail(), "Welcome to Customer", text);
				
				//final message
				 message="Customer Saved with Id:"+custId;
				
				if(flag)
					message+=",Email also sent successfully";
				else
					message+=",Email sending failed";

		//cust=service.saveCustomer(c);
		map.addAttribute("msg",custId);
		return "CustomRegister";
	}
	@RequestMapping(value="/allCustomers")
	public String getAllCustomers(ModelMap map) {
		List<Customer> li=service.loadAllCustomers();
		map.addAttribute("customer",li);
		return "CustData";
	}
	@RequestMapping(value="/customDelete")
	public String deleteCustomer(@RequestParam("cId")int cId) {
		service.delelteCustomer(cId);
		return "redirect:allCustomers";
	}
	@RequestMapping(value="/customerEdit")
	public String showCustomer(@RequestParam("cId")int cId,ModelMap map) {		
		Customer cust=service.getCustomerById(cId);
		map.addAttribute("cust",cust);
		return "CustomerEdit";
	}
	@RequestMapping(value="/editCustomer",method=RequestMethod.POST)
	public String updateCustomer(@ModelAttribute("customer")Customer c,ModelMap map) {
		//generate PWD,TOKEN
		String pwd=code.genPwd();
		String token=code.genToken();
	
		//encode pwd,token
		String encPwd=codec.doEncode(pwd);
		String encToken=codec.doEncode(token);
		
		//set encoded pwd,token to cust model object
		c.setcPwd(encPwd);
		c.setToken(encToken);
		
		//save cust object
		service.updateCustomer(c);
		
		//send email
		String text="Welcome to Customer : " +c.getcName()
				+" , your ID is  : "+c.getcEmail()
				+" , password is : "+pwd
				+" , Token is    : "+token
				+" , Type is     : "+c.getcType();
		
		boolean flag=common.sendEmail(c.getcEmail(), "Welcome to Customer", text);
		
		//final message
		// message="Customer Saved with Id:"+custId;
		
		if(flag)
			message+=",Email also sent successfully";
		else
			message+=",Email sending failed";


	//	service.updateCustomer(c);
		return "redirect:allCustomers";
	}
	@RequestMapping(value="/custExternalExcel")
	public String custExcelView(ModelMap map) {
		List<Customer> li=service.loadAllCustomers();
		map.addAttribute("li",li);
		return "custExcelView";
	}
	@RequestMapping(value="/customerExternalPdf")
	public String custPdfView(ModelMap map) {
		List<Customer> li=service.loadAllCustomers();
		map.addAttribute("li",li);
		return "custPdfView";
	}
	@RequestMapping(value="/custChartsAll")
	public String generateCharts() {
		List<Object[]> li=service.getchartReports();
		String path=context.getRealPath("/");
		util.generateBarChart(path, li);
		util.generatePie(path, li);
		return "CustomerReports";
	}
}
