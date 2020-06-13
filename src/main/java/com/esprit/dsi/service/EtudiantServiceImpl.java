package com.esprit.dsi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.dsi.model.Etudiant;
import com.esprit.dsi.repository.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements IEtudiantService {
	/*
	 * @Autowired private EntityManager entityManager;
	 */

	private EtudiantRepository strepo;

	@Autowired
	public EtudiantServiceImpl(EtudiantRepository strepo) {
		this.strepo = strepo;
	}

	@Override
	public List<Etudiant> getAllStudents() {
		return (List<Etudiant>) strepo.findAll();
	}

	@Override
	public Etudiant getStudentById(String id_et) {
		return strepo.findById(id_et).get();
	}

	@Override
	public Etudiant saveOrUpdate(Etudiant et) {
		// doc.setDocument_type(doc_typerepo.findById(doc.getDoctypeId()).get());
		return strepo.save(et);

	}

	@Override
	public Etudiant deleteStudentById(String id_et) {

		Etudiant etudiant = getStudentById(id_et);
		if (etudiant != null) {
			strepo.deleteById(id_et);
		}
		return etudiant;
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
