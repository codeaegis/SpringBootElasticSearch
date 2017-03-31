package com.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.springboot.model.TiaDocument;

public interface ElasticSearchService {

	public void save(TiaDocument metaDoc);

	public void delete(TiaDocument metaDoc);

	public TiaDocument findOne(String id);

	public Iterable<TiaDocument> findAll();

	public Page<TiaDocument> findById(String id, PageRequest pageRequest);
	
	public Page<TiaDocument> findByDocumentName(String documentName, PageRequest pageRequest);

	public Page<TiaDocument> findByUserName(String userName, PageRequest pageRequest);
	public List<TiaDocument> findByUserName(String userName);

}
