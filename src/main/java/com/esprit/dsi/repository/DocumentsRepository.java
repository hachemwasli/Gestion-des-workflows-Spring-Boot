package com.esprit.dsi.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.esprit.dsi.model.Document;

public interface DocumentsRepository extends CrudRepository<Document, Long>
{

@Query(nativeQuery = true, value="select * from Document d where d.id_et = :etudiantId")
List<Document> findByEtudiantId(String etudiantId);
@Query(nativeQuery = true, value="select * from Document d where d.id_doc = :id_doc and d.id_et = :etudiantId")
Document findByIdAndEtudiantId(Long id_doc, String etudiantId);
}
