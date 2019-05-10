package com.esprit.dsi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.esprit.dsi.model.Document;
import com.esprit.dsi.service.DocumentServiceImpl;

@Controller
public class DocumentController {
	@Autowired
	DocumentServiceImpl docService;

	@RequestMapping(value = "/")
	public String allDocs(Model model) {
		model.addAttribute("allDocs", docService.getAllDocuments());
		return "allDocs";
	}

	@RequestMapping(value = { "/docEdit", "/docEdit/{id_doc}" }, method = RequestMethod.GET)
	public String docEditForm(Model model, @PathVariable(required = false, name = "id_doc") Document doc) {
		if (null != doc) {
			model.addAttribute("document", docService.getDocumentById(doc.getId_doc()));
		} else {
			model.addAttribute("document", new Document());
		}
		return "editDoc";
	}

	@RequestMapping(value = "/editDoc", method = RequestMethod.POST)
	public String docEdit(Model model, Document document) {
		docService.saveOrUpdate(document);
		model.addAttribute("allDocs", docService.getAllDocuments());
		return "allDocs";
	}

	@RequestMapping(value = "/docDelete/{id_doc}", method = RequestMethod.GET)
	public String docDelete(Model model, @PathVariable(required = true, name = "id_doc") int id_doc) {
		docService.deleteDocumentById(id_doc);
		model.addAttribute("allDocs", docService.getAllDocuments());
		return "allDocs";
	}
	///test4

}
