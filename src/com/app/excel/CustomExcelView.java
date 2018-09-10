package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Customer;

public class CustomExcelView extends AbstractExcelView{

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook hw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.addHeader("Content-Disposition","attachment;fileName=Customer.xls");

		List<Customer> li=(List<Customer>) map.get("li");
		HSSFSheet sheet=hw.createSheet("li");
		setHeadder(sheet);
		setBody(sheet,li);
	}
	public void setHeadder(HSSFSheet sheet) {
		int rownum=0;
		HSSFRow row=sheet.createRow(rownum);
		row.createCell(0).setCellValue("Id");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Email");
		row.createCell(3).setCellValue("Type");
		row.createCell(4).setCellValue("Address");
		row.createCell(5).setCellValue("Password");
		row.createCell(6).setCellValue("Token");
		
	}
	public void setBody(HSSFSheet sheet,List<Customer>li) {
		int rownum=1;
		for(Customer cust:li) {
			HSSFRow row=sheet.createRow(rownum++);

			row.createCell(0).setCellValue(cust.getcId());
			row.createCell(1).setCellValue(cust.getcName());
			row.createCell(2).setCellValue(cust.getcEmail());
			row.createCell(3).setCellValue(cust.getcType());
			row.createCell(4).setCellValue(cust.getaddress());
			row.createCell(5).setCellValue(cust.getcPwd());
			row.createCell(6).setCellValue(cust.getToken());
			
		}
	}

}
