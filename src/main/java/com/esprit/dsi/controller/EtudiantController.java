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

import com.esprit.dsi.model.Etudiant;
import com.esprit.dsi.service.EtudiantServiceImpl;

//@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/etudiants" })
public class EtudiantController {
	
	@Autowired
	EtudiantServiceImpl etService;
	
	

	@GetMapping(produces = "application/json")
	public List<Etudiant> allEtudiants() {
		// model.addAttribute("allDocs", docService.getAllDocuments());
		return etService.getAllStudents();
	}

	@GetMapping(value = { "/{etudiantId}" })
	// @RequestMapping(value = { "/docEdit", "/docEdit/{id_doc}" }, method =
	// RequestMethod.GET)
	public Etudiant getEtudiantById(@PathVariable(required = false, name = "etudiantId") String etudiantId) {
		return etService.getStudentById(etudiantId);
	}

	@PostMapping(value = { "/add" })
	// @RequestMapping(value = "/docEdit", method = RequestMethod.POST)
	public Etudiant createDoc(@RequestBody Etudiant etudiant) {
		return etService.saveOrUpdate(etudiant);
		// model.addAttribute("allDocs", docService.getAllDocuments());
		// return "allDocs";
	}

	@PutMapping(value = { "/update/{etudiantId}" })
	// @RequestMapping(value = "/docEdit", method = RequestMethod.POST)
	public Etudiant updateDoc(@PathVariable(required = true, name = "etudiantId") String etudiantId, @RequestBody Etudiant etudiant) {
		return etService.saveOrUpdate(etudiant);
		// model.addAttribute("allDocs", docService.getAllDocuments());
		// return "allDocs";
	}

	@DeleteMapping(path = { "/delete/{etudiantId}" })
	// @RequestMapping(value = "/docDelete/{id_doc}", method = RequestMethod.GET)
	//@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public Etudiant deleteDoc(@PathVariable(required = true, name = "etudiantId") String etudiantId) {

		return etService.deleteStudentById(etudiantId);

	}

}
