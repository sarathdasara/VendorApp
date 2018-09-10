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

import com.app.charts.VendorPieChart;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Controller
public class VendorController {
	@Autowired
	private IVendorService service;
	@Autowired
	private ServletContext context;
	@Autowired
    private VendorPieChart vchart;
	
	@RequestMapping("/regVendor")
	public String showPage(){
		return "VenRegister";
	}
	//1----register the vendor values-------
	@RequestMapping(value="/venRegister",method=RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendor")Vendor v,ModelMap map){
		int ven=service.saveVendor(v);
		map.addAttribute("ved",ven);
		return "VenRegister";
		
	}
	//2------show all vendor details---
	@RequestMapping(value="/viewVendors")
	public String getAllVendors(ModelMap map){
	List<Vendor>ven=service.getAllVendors();
	map.addAttribute("vendor", ven);
		return "VenData";
		
	}
	@RequestMapping(value="/deleteVen")
	public String deleteVendors(@RequestParam("venId")int venId) {
		service.deleteVendor(venId);
		return "redirect:viewVendors";
	}
	@RequestMapping(value="/editVendor")
	public String showEditVendor(@RequestParam("venId")int venId,ModelMap map) {
		Vendor ven=service.getVendorById(venId);
		map.addAttribute("ven",ven);
		return "VendorEdit";
		
	}
	@RequestMapping(value="/updateVendor",method=RequestMethod.POST)
	public String updateVendor(@ModelAttribute("vendor")Vendor v) {
		service.updateVendor(v);
		return "redirect:viewVendors";
	}
    @RequestMapping(value="/vendorExternalSheet")
	public String vendorExcelView(ModelMap map) {
    List<Vendor> ven=service.getAllVendors();
    map.addAttribute("ven",ven);
		return "venExcelView";
	}
    @RequestMapping(value="/vendorPdfSheet")
   	public String vendorPdfView(ModelMap map) {
       List<Vendor> ven=service.getAllVendors();
       map.addAttribute("ven",ven);
   		return "venPdfView";
   	}
    @RequestMapping(value="/venChartsAll")
	public String generateReports() {
		List<Object[]> li=service.getVendorTypeCount();
		String path=context.getRealPath("/");
		vchart.generatePie(path, li);
		vchart.generateBarChart(path, li);
		return "VendorReports";
	}
}
