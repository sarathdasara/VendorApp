package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ItemDao;
import com.app.model.Item;
import com.app.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService{
@Autowired
	private ItemDao dao;
	public int saveItem(Item i) {
		return dao.saveItem(i);
	}
	public void updateItems(Item i) {
		dao.updateItems(i);
	}
	public void deleteItem(int id) {
		dao.deleteItem(id);
	}
	public Item getItemById(int id) {
		return dao.getItemById(id);
	}
	public List<Item> getAllItems() {
		return dao.getAllItems();
	}

}
