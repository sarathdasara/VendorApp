package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.charts.LocationPieChart;
import com.app.model.Location;
import com.app.service.ILocationService;

@Controller
public class LocationController {
	@Autowired
	private ILocationService service;
	@Autowired
	private LocationPieChart locchart;
	@Autowired
	private ServletContext context;
	String message=null;
	@RequestMapping("/regLoc")
	public String showPage(){
		return "UserMenu";
	}
	@RequestMapping("/insertLoc")
	public String registerPage(){
		return "InsertReg";
	}

	//1 ----save data in database---------
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String saveLocation(@ModelAttribute("location")Location loc,ModelMap map){
		int lId=service.saveLocation(loc);
		message="Location id added :"+lId;
		map.addAttribute("msg",lId);
		return "InsertReg";
	}
	//2---view all data in ui page-------
	@RequestMapping(value="/viewAll")
	public String loadAllLocations(ModelMap map){
		List<Location> loc=service.loadAllLocations();
		map.addAttribute("location",loc);
		return "LocData";

	}
	//3 -----delete data by id-------
	@RequestMapping(value="/deleteLoc")
	public String deleteLocation(@RequestParam("locId")int locId){
		service.delelteLocation(locId);
		return "redirect:viewAll";
		
	}
	//4---------edit the data-----------
	@RequestMapping(value="/editLoc")
	public String showLocEdit(@RequestParam("locId")int locId,ModelMap map){
		Location locob=service.getLocationById(locId);
		map.addAttribute("loc",locob);
		return"LocEdit";
	}
	//5--------update the data----
	@RequestMapping(value="/updateLoc", method=RequestMethod.POST)
	public String updateLocation(@ModelAttribute("location")Location loc){
		service.updateLocation(loc);
		return "redirect:viewAll";
	}
	//6 convert data toexcel format---------
	@RequestMapping("/locExcelSheet")
	public String locExcelFormat(ModelMap map){
		List<Location> locs=service.loadAllLocations();
		map.addAttribute("locs",locs);
		return "locExcelView";
	}
	@RequestMapping(value="/locPdfView")
	public String locPdfExternal(ModelMap map) {
		List<Location> locs=service.loadAllLocations();
		map.addAttribute("locs",locs);
		return "locPdfSheet";
	}
	@RequestMapping(value="/locChartsAll")
	public String generateReports() {
		List<Object[]> li=service.getLocationTypeCount();
		String path=context.getRealPath("/");
		locchart.generatePie(path, li);
		locchart.generateBarChart(path, li);
		return "LocationReports";
	}
	
	
}
