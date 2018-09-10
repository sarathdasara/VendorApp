package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {
	//----------vendor module-----//
		public int saveVendor(Vendor v);
		public List<Vendor> getAllVendors();
		public void deleteVendor(int venId);
		public Vendor getVendorById(int venId);
		public void updateVendor(Vendor v);
		public List<Object[]> getVendorTypeCount();

}
