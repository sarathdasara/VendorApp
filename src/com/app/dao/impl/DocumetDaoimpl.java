package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumetDao;
import com.app.model.Document;
@Repository
public class DocumetDaoimpl implements IDocumetDao{

	@Autowired
	private HibernateTemplate ht;
	
	public int saveDocument(Document doc) {
		return (Integer) ht.save(doc);
	}

	
	public List<Object[]> getDocsIdAndName() {
		String hql="select fileId,fileName from com.app.model.Document";
		List<Object[]> obs=ht.find(hql);
		return obs;
	}

	public Document getDocumentById(int fileId) {
		return ht.get(Document.class, fileId);
	}

}



