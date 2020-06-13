package com.esprit.dsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.dsi.model.Document_Type;
import com.esprit.dsi.repository.DocumentsTypeRepository;

@Service
public class DocumentTypeServiceImpl implements IDocumentTypeService {
	/*
	 * @Autowired private EntityManager entityManager;
	 */
	
    private DocumentsTypeRepository doc_typerepo;

    @Autowired
	public DocumentTypeServiceImpl(DocumentsTypeRepository doc_typerepo) {
		this.doc_typerepo=doc_typerepo;
	}

	@Override
	public List<Document_Type> getAllDocumentTypes() {
		return (List<Document_Type>) doc_typerepo.findAll();
	}

	@Override
	public Document_Type getDocumentTypeById(Long id_typedoc) {
		return doc_typerepo.findById(id_typedoc).get();
	}

	@Override
	public Document_Type saveOrUpdate(Document_Type doc) {
		return doc_typerepo.save(doc);

	}

	@Override
	public Document_Type deleteDocumentTypeById(Long id_typedoc) {
		
		 Document_Type Document_Type = getDocumentTypeById(id_typedoc);
	        if(Document_Type != null){
	        	doc_typerepo.deleteById(id_typedoc);
	        }
	        return Document_Type;
	    }


}
