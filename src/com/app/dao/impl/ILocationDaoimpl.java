package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocatioDao;
import com.app.model.Location;


@Repository
public class ILocationDaoimpl implements ILocatioDao {
	@Autowired
	private HibernateTemplate ht;
	
	public int saveLocation(Location loc) {
		return (Integer) ht.save(loc);
	}


	public void updateLocation(Location loc) {
		ht.update(loc);
	}

	public void delelteLocation(int locId) {

		Location loc=new Location(locId);
		ht.delete(loc);
	}

	public Location getLocationById(int locId) {
		return ht.get(Location.class, locId);
	}

	public List<Location> loadAllLocations() {
		return ht.loadAll(Location.class);
	}

	public List<Object[]> getLocationTypeCount() {
		String hql="select locType,count(locType) from com.app.model.Location group by locType";
		@SuppressWarnings("unchecked")
		List<Object[]> li=ht.find(hql);
		return li;
	}


	

}