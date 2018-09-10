package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;
@Service
public class IVendorServiceimpl implements IVendorService{ 
	@Autowired
	private IVendorDao dao;
	public int saveVendor(Vendor v) {
		return dao.saveVendor(v);
	}

	public List<Vendor> getAllVendors() {
		return dao.getAllVendors();
	}

	public void deleteVendor(int venId) {
		dao.deleteVendor(venId);	
	}

	public Vendor getVendorById(int venId) {
		return dao.getVendorById(venId);
	}

	public void updateVendor(Vendor v) {
		dao.updateVendor(v);		
	}

	public List<Object[]> getVendorTypeCount() {
		return dao.getVendorTypeCount();
	}

}
