package com.esprit.dsi.service;

import java.util.List;

import com.esprit.dsi.model.Document_Type;

public interface IDocumentTypeService {
	
	 public List<Document_Type> getAllDocumentTypes();
	 
	 public Document_Type getDocumentTypeById(Long id_doc);
	 
	 public Document_Type saveOrUpdate(Document_Type doc);
	 
	 public Document_Type deleteDocumentTypeById(Long id_doc);
}
