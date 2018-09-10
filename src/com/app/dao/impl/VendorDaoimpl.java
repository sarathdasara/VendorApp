package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
@Repository
public class VendorDaoimpl implements IVendorDao{
	@Autowired
	private HibernateTemplate ht;

	public int saveVendor(Vendor v) {	
		return (Integer) ht.save(v);
	}
	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);		
	}
	public void deleteVendor(int venId) {
		Vendor v=new Vendor(venId);
		ht.delete(v);
	}
	public Vendor getVendorById(int venId) {
		return ht.get(Vendor.class,venId);
	}
	public void updateVendor(Vendor v) {
		ht.update(v);
	}
	public List<Object[]> getVendorTypeCount() {
		String hql="select venType,count(venType) from com.app.model.Vendor group by venType";
		@SuppressWarnings("unchecked")
		List<Object[]> li=ht.find(hql);
		return li;
	}

}

