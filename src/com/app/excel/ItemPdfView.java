package com.app.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView{

	@SuppressWarnings("unchecked")
	protected void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.addHeader("Content-Disposition","attachment;fileName=Item.pdf");
		List<Item> li=(List<Item>) map.get("li");
		PdfPTable p=new PdfPTable(5);
		p.addCell("ID");
		p.addCell("NAME");
		p.addCell("COST");
		p.addCell("DISCOUNT");
		p.addCell("COSTID");
		for(Item i:li){
			p.addCell(i.getId()+"");
			p.addCell(i.getItemName());
			p.addCell(i.getItemCost()+"");
			p.addCell(i.getDiscount()+"");
			p.addCell(i.getCostId()+"");
		}
		doc.add(p);
	}

}
