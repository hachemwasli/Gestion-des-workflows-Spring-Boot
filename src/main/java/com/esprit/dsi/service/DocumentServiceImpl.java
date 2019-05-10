package com.esprit.dsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.dsi.model.Document;
import com.esprit.dsi.repository.DocumentsRepository;

@Service
public class DocumentServiceImpl implements IDocumentService {
	/*
	 * @Autowired private EntityManager entityManager;
	 */
	@Autowired
	DocumentsRepository docrepo;

	public DocumentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Document> getAllDocuments() {
		return (List<Document>) docrepo.findAll();
	}

	@Override
	public Document getDocumentById(int id_doc) {
		return docrepo.findById(id_doc).get();
	}

	@Override
	public void saveOrUpdate(Document doc) {
		docrepo.save(doc);

	}

	@Override
	public void deleteDocumentById(int id_doc) {
		docrepo.deleteById(id_doc);

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
