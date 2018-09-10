package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface ItemService {
	public int saveItem(Item i);
	public void updateItems(Item i);
	public void deleteItem(int id);
	public Item getItemById(int id);
	public List<Item> getAllItems();

}
