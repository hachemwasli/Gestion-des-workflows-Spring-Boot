package com.esprit.dsi.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Document")
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_doc;
	private String code_doc;
	private String nom_doc;
	private String description_doc;
	private transient String etudiantId;
	private transient Long doctypeId;
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "id_typedoc", nullable = false,
	 * insertable=false,updatable=false) private Document_Type document_type;
	 */

	@ManyToOne
	@JoinColumn(name = "id_et", nullable = false, referencedColumnName = "id_et", insertable = true, updatable = true)
	// @JsonManagedReference
	private Etudiant etudiant;

	@ManyToOne
	@JoinColumn(name = "id_typedoc", nullable = false, referencedColumnName = "id_typedoc", insertable = true, updatable = true)
	// @JsonManagedReference
	private Document_Type document_type;

	public Document() {
		super();
	}

	public Long getId_doc() {
		return id_doc;
	}

	public void setId_doc(Long id_doc) {
		this.id_doc = id_doc;
	}

	public String getCode_doc() {
		return code_doc;
	}

	public void setCode_doc(String code_doc) {
		this.code_doc = code_doc;
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

	public String getEtudiantId() {
		return etudiantId;
	}

	public void setEtudiantId(String etudiantId) {
		this.etudiantId = etudiantId;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Long getDoctypeId() {
		return doctypeId;
	}

	public void setDoctypeId(Long doctypeId) {
		this.doctypeId = doctypeId;
	}

	public Document_Type getDocument_type() {
		return document_type;
	}

	public void setDocument_type(Document_Type document_type) {
		this.document_type = document_type;
	}

}
