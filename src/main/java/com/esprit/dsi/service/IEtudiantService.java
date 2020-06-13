package com.esprit.dsi.service;

import java.util.List;

import com.esprit.dsi.model.Etudiant;

public interface IEtudiantService {
	
	 public List<Etudiant> getAllStudents();
	 
	 public Etudiant getStudentById(String id_et);
	 
	 public Etudiant saveOrUpdate(Etudiant et);
	 
	 public Etudiant deleteStudentById(String id_et);
	 
	 //public Document getDocumentsByTypeId(int id_typedoc);
}
