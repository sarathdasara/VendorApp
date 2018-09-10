package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Location;

public class LocExcelView extends AbstractExcelView {

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		res.addHeader("Content-Disposition","attachment;fileName=Location.xls");
		//read data from modelmap
		List<Location> locs=(List<Location>) map.get("locs");

		//create sheet
		HSSFSheet sheet=book.createSheet("locs");
		//set the head row zero
		setHead(sheet);
		//setbody list of rows
		setBody(sheet,locs);

	}
	private void setHead(HSSFSheet sheet){
		int rownum=0;
		HSSFRow row=sheet.createRow(rownum);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("NOTE");

	}
	private void setBody(HSSFSheet sheet, List<Location> locs){
		int rownum=1;
		for(Location loc:locs){
			HSSFRow row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(loc.getLocId());
			row.createCell(1).setCellValue(loc.getLocName());
			row.createCell(2).setCellValue(loc.getLocCode());
			row.createCell(3).setCellValue(loc.getLocType());
			row.createCell(4).setCellValue(loc.getLocDsc());


		}
	}
}
