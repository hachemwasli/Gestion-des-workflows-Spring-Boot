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

import com.esprit.dsi.model.Document;
import com.esprit.dsi.service.DocumentServiceImpl;


//@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/etudiants/{etudiantId}/documents" })
public class DocumentController {

	DocumentServiceImpl docService;

	@Autowired
	public DocumentController(DocumentServiceImpl docService) {
		this.docService = docService;
	}

	@GetMapping(produces = "application/json")
	public List<Document> allDocsByStudentId(@PathVariable(required = false, name = "etudiantId") String etudiantId) {
		// model.addAttribute("allDocs", docService.getAllDocuments());
		return docService.getDocumentByStudentId(etudiantId);
	}

	/*
	 * @GetMapping(value = { "/etudiants/{etudiantId}/{documentId}" })
	 * // @RequestMapping(value = { "/docEdit", "/docEdit/{id_doc}" }, method = //
	 * RequestMethod.GET) public Document
	 * getDocByIdAndStudentId(@PathVariable(required = false, name = "documentId")
	 * Long documentId,
	 * 
	 * @PathVariable(required = false, name = "etudiantId") String etudiantId) {
	 * return docService.getDocumentByIdAndStudentId(documentId, etudiantId); }
	 */

	@GetMapping(value = { "/{id_doc}" })
	public Document getDocByIdAndStudentId(@PathVariable(required = false, name = "id_doc") Long id_doc,
			@PathVariable(required = false, name = "etudiantId") String etudiantId) {
		return docService.getDocumentByIdAndStudentId(id_doc, etudiantId);
	}

	@PostMapping(value = { "/add" })
	// @RequestMapping(value = "/docEdit", method = RequestMethod.POST)
	public Document createDoc(@PathVariable(required = false, name = "etudiantId") String etudiantId,
			@RequestBody Document document) {
		return docService.saveOrUpdate(etudiantId, document);
		// model.addAttribute("allDocs", docService.getAllDocuments());
		// return "allDocs";

	}

	@PutMapping(value = { "/update/{id_doc}" })
	// @RequestMapping(value = "/docEdit", method = RequestMethod.POST)
	public Document updateDoc(@PathVariable(required = false, name = "id_doc") Long id_doc,
			@PathVariable(required = false, name = "etudiantId") String etudiantId, @RequestBody Document document) {
		docService.getDocumentById(id_doc);
		document.setId_doc(id_doc);
		return docService.saveOrUpdate(etudiantId, document);
		// model.addAttribute("allDocs", docService.getAllDocuments());
		// return "allDocs";
	}

	@DeleteMapping(path = { "/delete/{id_doc}" })
	// @RequestMapping(value = "/docDelete/{id_doc}", method = RequestMethod.GET)
	// @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Document deleteDoc(@PathVariable(required = false, name = "id_doc") Long id_doc,
			@PathVariable(required = false, name = "etudiantId") String etudiantId) {
		return docService.deleteDocumentByIdAndStudentId(id_doc, etudiantId);

	}
}
