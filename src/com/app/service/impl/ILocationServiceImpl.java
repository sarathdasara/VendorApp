package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocatioDao;
import com.app.model.Location;
import com.app.service.ILocationService;
@Service
public class ILocationServiceImpl implements ILocationService {
	@Autowired
	private ILocatioDao dao;

	public int saveLocation(Location loc) {
		return dao.saveLocation(loc);
	}

	public void updateLocation(Location loc) {
		dao.updateLocation(loc);
	}

	public void delelteLocation(int locId) {
		dao.delelteLocation(locId);
	}

	public Location getLocationById(int locId) {
		return dao.getLocationById(locId);
	}

	public List<Location> loadAllLocations() {
		return dao.loadAllLocations();
	}

	

	public List<Object[]> getLocationTypeCount() {
		return dao.getLocationTypeCount();
	}

}
