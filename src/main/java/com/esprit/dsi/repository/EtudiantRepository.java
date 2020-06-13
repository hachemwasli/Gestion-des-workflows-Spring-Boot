package com.esprit.dsi.repository;

import org.springframework.data.repository.CrudRepository;


import com.esprit.dsi.model.Etudiant;

public interface EtudiantRepository extends CrudRepository<Etudiant, String>
{

}
