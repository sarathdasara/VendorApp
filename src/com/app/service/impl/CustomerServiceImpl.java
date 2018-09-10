package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerDao dao;
	public int saveCustomer(Customer c) {
		return dao.saveCustomer(c);
	}

	public void updateCustomer(Customer c) {
		dao.updateCustomer(c);
	}

	public void delelteCustomer(int cId) {
		dao.delelteCustomer(cId);		
	}

	public Customer getCustomerById(int cId) {
		return dao.getCustomerById(cId);
	}

	public List<Customer> loadAllCustomers() {
		return dao.loadAllCustomers();
	}

	public List<Object[]> getchartReports() {
		return dao.getchartReports();
	}

}
