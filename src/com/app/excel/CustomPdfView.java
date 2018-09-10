package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Customer;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CustomPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.addHeader("Content-Disposition","attachment;fileName=customer.pdf");
		List<Customer> li=(List<Customer>) map.get("li");
		PdfPTable pt=new PdfPTable(7);

		pt.addCell("Id");
		pt.addCell("Name");
		pt.addCell("Email");
		pt.addCell("Type");
		pt.addCell("Address");
		pt.addCell("Passwword");
		pt.addCell("Token");
		for(Customer cust:li) {
			pt.addCell(cust.getcId()+"");
			pt.addCell(cust.getcName());
			pt.addCell(cust.getcEmail());
			pt.addCell(cust.getcType());
			pt.addCell(cust.getaddress());
			pt.addCell(cust.getcPwd());
			pt.addCell(cust.getToken());
		}
		doc.add(pt);
	}

}
