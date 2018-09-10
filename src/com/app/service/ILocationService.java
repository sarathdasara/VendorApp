package com.app.service;

import java.util.List;

import com.app.model.Location;

public interface ILocationService {

	public int saveLocation(Location loc);
	public void updateLocation(Location loc);
	public  void delelteLocation(int locId);
	public Location getLocationById(int locId);
	public List<Location> loadAllLocations();
	public List<Object[]> getLocationTypeCount();
}
