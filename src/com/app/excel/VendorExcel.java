package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.app.model.Vendor;

public class VendorExcel extends AbstractExcelView{

	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook book, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.addHeader("Content-Disposition","attachment;fileName=Vendor.xls");
		List<Vendor> ven=(List<Vendor>) map.get("ven");
		HSSFSheet sheet=book.createSheet("ven");
		setHead(sheet);
		setBody(sheet, ven);

	}
	private void setHead(HSSFSheet sheet) {
		int rownum=0;
		HSSFRow row=sheet.createRow(rownum);
		row.createCell(0).setCellValue("id");
		row.createCell(1).setCellValue("code");
		row.createCell(2).setCellValue("name");
		row.createCell(3).setCellValue("type");
		row.createCell(4).setCellValue("address");
		row.createCell(5).setCellValue("idtype");
		row.createCell(6).setCellValue("idNum");
		row.createCell(7).setCellValue("Description");
	}
	private void setBody(HSSFSheet sheet, List<Vendor> ven) {
		int rownum=1;
		for(Vendor v:ven) {
			HSSFRow row=sheet.createRow(rownum++);
			row.createCell(0).setCellValue(v.getVenId());
			row.createCell(1).setCellValue(v.getVenCode());
			row.createCell(2).setCellValue(v.getVenName());
			row.createCell(3).setCellValue(v.getVenType());
			row.createCell(4).setCellValue(v.getVenAdd());
			row.createCell(5).setCellValue(v.getIdType());
			row.createCell(6).setCellValue(v.getIdNum());
			row.createCell(7).setCellValue(v.getVenDsc());
		}

	}
}