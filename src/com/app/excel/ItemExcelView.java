package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Item;

public class ItemExcelView extends AbstractExcelView{

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.addHeader("Content-Disposition","attachment;fileName=Item.xls");

		List<Item> li=(List<Item>) map.get("li");
		HSSFSheet sheet=book.createSheet("li");
		setHeadder(sheet);
		setBody(sheet,li);
	}
	public void setHeadder(HSSFSheet sheet){
		int rownum=0;
		HSSFRow row=sheet.createRow(rownum);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("COST");
		row.createCell(3).setCellValue("DISCOUNT");
		row.createCell(4).setCellValue("COSTID");
	}
	public void setBody(HSSFSheet sheet,List<Item> li){
		int rownum=1;
		for(Item i:li){
		HSSFRow row=sheet.createRow(rownum++);
		row.createCell(0).setCellValue(i.getId());
		row.createCell(1).setCellValue(i.getItemName());
		row.createCell(2).setCellValue(i.getItemCost());
		row.createCell(3).setCellValue(i.getDiscount());
		row.createCell(4).setCellValue(i.getCostId());
	}
	}
}
