package com.app.service;

import java.util.List;

import com.app.model.Customer;

public interface ICustomerService {
	public int saveCustomer(Customer c);
	public void updateCustomer(Customer c);
	public  void delelteCustomer(int cId);
	public Customer getCustomerById(int cId);
	public List<Customer> loadAllCustomers();
	public List<Object[]> getchartReports();



}
