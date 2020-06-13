package com.esprit.dsi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.dsi.model.Document_Type;
import com.esprit.dsi.service.DocumentTypeServiceImpl;

//@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/doctypes" })
public class DocumentTypeController {
	
	@Autowired
	DocumentTypeServiceImpl doctypeService;



	@GetMapping(produces = "application/json")
	public List<Document_Type> allDocTypes() {
		// model.addAttribute("allDocs", docService.getAllDocumentTypes());
		return doctypeService.getAllDocumentTypes();
	}

	@GetMapping(value = { "/{id_docType}" })
	// @RequestMapping(value = { "/docEdit", "/docEdit/{id_doc}" }, method =
	// RequestMethod.GET)
	public Document_Type getDocTypeById(@PathVariable(required = false, name = "id_docType") Long id_docType) {
		return doctypeService.getDocumentTypeById(id_docType);
	}

	@PostMapping(value = { "/add" })
	// @RequestMapping(value = "/docEdit", method = RequestMethod.POST)
	public Document_Type createDocType(@RequestBody Document_Type document_Type) {
		return doctypeService.saveOrUpdate(document_Type);
		// model.addAttribute("allDocs", docService.getAllDocumentTypes());
		// return "allDocs";
	}

	@PutMapping(value = { "/update/{id}" })
	// @RequestMapping(value = "/docEdit", method = RequestMethod.POST)
	public Document_Type updateDocType(@PathVariable(required = true, name = "id_docType") Long id_docType, @RequestBody Document_Type document_Type) {
		return doctypeService.saveOrUpdate(document_Type);
		// model.addAttribute("allDocs", docService.getAllDocumentTypes());
		// return "allDocs";
	}

	@DeleteMapping(path = { "/delete/{id}" })
	// @RequestMapping(value = "/docDelete/{id_doc}", method = RequestMethod.GET)
	//@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Document_Type deleteDocType(@PathVariable(required = true, name = "id_docType") Long id_docType) {

		return doctypeService.deleteDocumentTypeById(id_docType);

	}

}
