package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService service;
	@RequestMapping(value="/showItem")
	public String showItem(){
		return "ItemRegister";
	}
	@RequestMapping(value="/itemRegis",method=RequestMethod.POST)
	public String saveItem(@ModelAttribute("item")Item i,ModelMap map){
		int id2=service.saveItem(i);
		map.addAttribute("msg",id2);
		return "ItemRegister";
	}

	@RequestMapping(value="/viewItems")
	public String showAllItems(ModelMap map){
	List<Item> li=service.getAllItems();
	map.addAttribute("i",li);
		return "ItemViews";
	}
	@RequestMapping(value="/deleteItem")
	public String deleteItem(@RequestParam("id")int id){
		service.deleteItem(id);
		return "redirect:viewItems";
	}
	@RequestMapping(value="/editItem1")
	public String editItem(@RequestParam("id")int id,ModelMap map){
		Item i=service.getItemById(id);
		map.addAttribute("i",i);
		return "ItemEdit";
	}
	@RequestMapping(value="editItem",method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("item")Item i){
		service.updateItems(i);
		return "redirect:viewItems";
	}
	@RequestMapping(value="/ItemExcelSheet")
	public String itemExcel(ModelMap map){
		List<Item> li=service.getAllItems();
		map.addAttribute("li",li);
		return "itemExcelView";
	}
	@RequestMapping(value="/ItemPdfView")
	public String itemPdf(ModelMap map){
		List<Item> li=service.getAllItems();
		map.addAttribute("li",li);

		return "itemPdfView";
	}
}
