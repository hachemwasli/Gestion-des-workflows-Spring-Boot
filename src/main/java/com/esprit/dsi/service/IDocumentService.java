package com.esprit.dsi.service;

import java.util.List;
import java.util.Optional;

import com.esprit.dsi.model.Document;

public interface IDocumentService {
	
	 public List<Document> getDocumentByStudentId(String etudiantId);
	 
	 public Document getDocumentByIdAndStudentId(Long id_doc, String etudiantId);
	 
	 public Document getDocumentById(Long id_doc);
	 
	 public Document saveOrUpdate(String etudiantId, Document doc);
	 
	 public Document deleteDocumentByIdAndStudentId(Long id_doc, String etudiantId);
	 
	 //public Document getDocumentsByTypeId(int id_typedoc);
}
