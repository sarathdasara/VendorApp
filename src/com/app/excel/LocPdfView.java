package com.app.excel;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Location;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class LocPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		res.addHeader("Content-Disposition","attachment;fileName=Location.pdf");
		List<Location> locs=(List<Location>) map.get("locs");
		
		//create paragraph
		Paragraph p=new Paragraph("welcome to pdf? ? ? ");
		//----create pdf table--
		PdfPTable pt=new PdfPTable(5);
		pt.addCell("Id");
		pt.addCell("Name");
		pt.addCell("Code");
		pt.addCell("Type");
		pt.addCell("Desc");
		
		for(Location loc:locs) {
			pt.addCell(loc.getLocId()+" ");
			pt.addCell(loc.getLocName());
			pt.addCell(loc.getLocCode());
			pt.addCell(loc.getLocType());
			pt.addCell(loc.getLocDsc());
		}
		//-------add elements to document
			doc.add(p);
			doc.add(pt);
			doc.add(new Paragraph(new Date().toString()));
			
			
		
	}

}
