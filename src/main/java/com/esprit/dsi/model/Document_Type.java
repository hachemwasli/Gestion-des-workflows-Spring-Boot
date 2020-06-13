package com.esprit.dsi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Type_Document")
public class Document_Type implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_typedoc;
	private String code_type;
	private String type_doc;

	public Document_Type() {
		super();
	}

	/*
	 * @OneToMany(mappedBy = "document_type", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY) private List<Document> documents;
	 */

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	// @JsonBackReference
	private List<Document> documents;

	public Long getId_typedoc() {
		return id_typedoc;
	}

	public void setId_typedoc(Long id_typedoc) {
		this.id_typedoc = id_typedoc;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getType_doc() {
		return type_doc;
	}

	public void setType_doc(String type_doc) {
		this.type_doc = type_doc;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

}
