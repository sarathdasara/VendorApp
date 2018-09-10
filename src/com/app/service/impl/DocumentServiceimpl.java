package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IDocumetDao;
import com.app.model.Document;
import com.app.service.IDocumentService;
@Service
public class DocumentServiceimpl implements IDocumentService{
	@Autowired
	private IDocumetDao dao;
	
	public int saveDocument(Document doc) {
		return dao.saveDocument(doc);
	}
	public List<Object[]> getDocsIdAndName() {
		return dao.getDocsIdAndName();
	}
	public Document getDocumentById(int fileId) {
		return dao.getDocumentById(fileId);
	}
}