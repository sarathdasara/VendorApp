package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements ItemDao{
@Autowired
	private HibernateTemplate ht;
	public int saveItem(Item i) {
		int id=(Integer) ht.save(i);
		return id;
	}
	public void updateItems(Item i) {
		ht.update(i);
	}
	public void deleteItem(int id) {
	Item i=new Item(id);
	ht.delete(i);
	}
	public Item getItemById(int id) {
		return ht.get(Item.class, id);

	}
	public List<Item> getAllItems() {
		return ht.loadAll(Item.class);
	}

}
