package com.esprit.dsi.service;

import java.util.List;

import com.esprit.dsi.model.Document;

public interface IDocumentService {
	
	 public List<Document> getAllDocuments();
	 
	 public Document getDocumentById(int id_doc);
	 
	 public void saveOrUpdate(Document doc);
	 
	 public void deleteDocumentById(int id_doc);
}
