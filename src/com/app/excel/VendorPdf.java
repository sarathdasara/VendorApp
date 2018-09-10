package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Vendor;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class VendorPdf extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.addHeader("Content-Disposition","attachment;fileName=Vendor.pdf");
		List<Vendor> v=(List<Vendor>) map.get("ven");
		Paragraph p=new Paragraph("welcome to vendor");
		PdfPTable pt=new PdfPTable(8);
		pt.addCell("id");
		pt.addCell("Code");
		pt.addCell("Name");
		pt.addCell("Type");
		pt.addCell("Address");
		pt.addCell("idNum");
		pt.addCell("idType");
		pt.addCell("Description");
		for(Vendor ven:v) {
			pt.addCell(ven.getVenId()+"");
			pt.addCell(ven.getVenCode());
			pt.addCell(ven.getVenName());
			pt.addCell(ven.getVenType());
			pt.addCell(ven.getVenAdd());
			pt.addCell(ven.getIdNum());
			pt.addCell(ven.getIdType());
			pt.addCell(ven.getVenDsc());
		}
		doc.add(p);
		doc.add(pt);
	}

}
