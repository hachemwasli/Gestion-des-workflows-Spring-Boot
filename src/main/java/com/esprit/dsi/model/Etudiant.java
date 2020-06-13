package com.esprit.dsi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "esp_etudiant")
public class Etudiant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(columnDefinition = "VARCHAR(10)")
	private String id_et;
	@Column(columnDefinition = "VARCHAR(30)")
	private String nom_et;
	@Column(columnDefinition = "VARCHAR(30)")
	private String pnom_et;
	@Column(columnDefinition = "VARCHAR(120)")
	private String tel_et;
	@Column(columnDefinition = "VARCHAR(60)")
	private String e_mail_et;

	// @OneToMany(mappedBy = "id_et", cascade = CascadeType.ALL)
	// private List<Document> et_docs;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Document> documents;

	public Etudiant() {
		super();
	}

	public String getId_et() {
		return id_et;
	}

	public void setId_et(String id_et) {
		this.id_et = id_et;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getNom_et() {
		return nom_et;
	}

	public void setNom_et(String nom_et) {
		this.nom_et = nom_et;
	}

	public String getPnom_et() {
		return pnom_et;
	}

	public void setPnom_et(String pnom_et) {
		this.pnom_et = pnom_et;
	}

	public String getTel_et() {
		return tel_et;
	}

	public void setTel_et(String tel_et) {
		this.tel_et = tel_et;
	}

	public String getE_mail_et() {
		return e_mail_et;
	}

	public void setE_mail_et(String e_mail_et) {
		this.e_mail_et = e_mail_et;
	}

}
