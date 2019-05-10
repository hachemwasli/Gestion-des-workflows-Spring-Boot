package com.esprit.dsi.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.dsi.model.Document;

public interface DocumentsRepository extends CrudRepository<Document, Integer>
{

}
