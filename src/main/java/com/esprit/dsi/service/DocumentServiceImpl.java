package com.esprit.dsi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.dsi.model.Document;
import com.esprit.dsi.model.Etudiant;
import com.esprit.dsi.repository.DocumentsRepository;
import com.esprit.dsi.repository.DocumentsTypeRepository;
import com.esprit.dsi.repository.EtudiantRepository;

@Service
public class DocumentServiceImpl implements IDocumentService {
	/*
	 * @Autowired private EntityManager entityManager;
	 */

	private DocumentsRepository docrepo;
	private DocumentsTypeRepository doc_typerepo;
	private EtudiantRepository strepo;

	@Autowired
	public DocumentServiceImpl(DocumentsRepository docrepo, DocumentsTypeRepository doc_typerepo,
			EtudiantRepository strepo) {
		this.docrepo = docrepo;
		this.doc_typerepo = doc_typerepo;
		this.strepo = strepo;
	}

	@Override
	public List<Document> getDocumentByStudentId(String etudiantId) {
		
	return (List<Document>) docrepo.findByEtudiantId(etudiantId);
	/*
	 * 	// return (List<Document>) docrepo.findByEtudiantId(etudiantId);
		List<Document> documents = null;
		try {

			documents = (List<Document>) docrepo.findAll();

			for (Document document : documents) {
				Boolean b = true;
				Optional<Etudiant> byId = strepo.findById(etudiantId);
				Etudiant etudiant2 = byId.get();
				Etudiant etudiant = document.getEtudiant();
				if (etudiant.getId_et().equals(etudiant2.getId_et()))
					b = false;

				if (b)
					documents.remove(document);
			}
			return documents;
		} catch (Exception e) {
			System.out.print("Probleme document");
			return documents;
		}
	 * */
	
	}

	@Override
	public Document getDocumentByIdAndStudentId(Long id_doc, String etudiantId) {
	return docrepo.findByIdAndEtudiantId(id_doc, etudiantId);
	/*
	 * 	Document document = null;
		try {

			document = getDocumentById(id_doc);

			strepo.findById(etudiantId).get();

			return document;
		} catch (Exception e) {
			System.out.print("Probleme document");
			return document;
		}
	 * */
	}

	@Override
	public Document getDocumentById(Long id_doc) {
		return docrepo.findById(id_doc).get();
	}

	@Override
	public Document saveOrUpdate(String etudiantId, Document doc) {
		Optional<Etudiant> byId = strepo.findById(etudiantId);

		Etudiant etudiant = byId.get();

		doc.setEtudiant(etudiant);
		doc.setDocument_type(doc_typerepo.findById(doc.getDoctypeId()).get());
		return docrepo.save(doc);

	}

	@Override
	public Document deleteDocumentByIdAndStudentId(Long id_doc, String etudiantId) {

		Document document = getDocumentByIdAndStudentId(id_doc, etudiantId);
		if (document != null) {
			docrepo.delete(document);
		}
		return document;
	}
	/*
	 * @Override public Boolean addDocuments(Documents d) { Boolean b = false; try {
	 * entityManager.persist(d);
	 * 
	 * b = true; } catch (Exception e) {
	 * 
	 * } return b; }
	 * 
	 * @Override public Boolean updateDocuments(Documents d) { Boolean b = false;
	 * try { entityManager.merge(d); b = true; } catch (Exception e) { } return b; }
	 * 
	 * @Override public Documents findDocumentsById(int id_doc) { return
	 * entityManager.find(Documents.class, id_doc); }
	 * 
	 * @Override public Boolean deleteDocumentsById(int id_doc) { Boolean b = false;
	 * try { entityManager.remove(findDocumentsById(id_doc)); b = true; } catch
	 * (Exception e) { } return b; }
	 * 
	 * @Override public List<Documents> findAllDocuments() { String jpql =
	 * "select d from Documents d"; Query query = entityManager.createQuery(jpql);
	 * return query.getResultList(); }
	 */

}
