package com.esprit.dsi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id_doc;
	private String nom_doc;
	private String description_doc;
	
	public int getId_doc() {
		return id_doc;
	}
	public void setId_doc(int id_doc) {
		this.id_doc = id_doc;
	}
	public String getNom_doc() {
		return nom_doc;
	}
	public void setNom_doc(String nom_doc) {
		this.nom_doc = nom_doc;
	}
	public String getDescription_doc() {
		return description_doc;
	}
	public void setDescription_doc(String description_doc) {
		this.description_doc = description_doc;
	}
	

}
