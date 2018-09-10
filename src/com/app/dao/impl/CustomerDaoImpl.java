package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	@Autowired

	private HibernateTemplate ht;
	public int saveCustomer(Customer c) {
		return (Integer) ht.save(c);

	}

	public void updateCustomer(Customer c) {
		ht.update(c);
	}

	public void delelteCustomer(int cId) {

		Customer cc=new Customer(cId);
		ht.delete(cc);
	}

	public Customer getCustomerById(int cId) {
		return ht.get(Customer.class, cId);
	}

	public List<Customer> loadAllCustomers() {
		return ht.loadAll(Customer.class);
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getchartReports() {
		String hql="select cType,count(cType) from com.app.model.Customer group by cType";
		List<Object[]> li=ht.find(hql);
		return li;
	}

}
