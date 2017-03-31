package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.model.TiaDocument;
import com.springboot.repo.MetaDocRepository;
import com.springboot.service.ElasticSearchService;

@Service
public class ElasticSearchServiceImpl implements ElasticSearchService {
	
	@Autowired
	private MetaDocRepository metaDocRepo;
	
	@Override
	public void save(TiaDocument metaDoc) {
		metaDocRepo.save(metaDoc);
	}

	@Override
    public void delete(TiaDocument metaDoc) {
    	metaDocRepo.delete(metaDoc);
    }

	@Override
    public TiaDocument findOne(String id) {
        return metaDocRepo.findOne(id);
    }

	@Override
    public Iterable<TiaDocument> findAll() {
        return metaDocRepo.findAll();
    }
	
	@Override
    public Page<TiaDocument> findById(String id, PageRequest pageRequest) {
        return metaDocRepo.findById(id, pageRequest);
    }

	@Override
    public Page<TiaDocument> findByDocumentName(String documentName, PageRequest pageRequest) {
        return metaDocRepo.findByDocumentName(documentName, pageRequest);
    }
	
	@Override
    public Page<TiaDocument> findByUserName(String userName, PageRequest pageRequest) {
        return metaDocRepo.findByUserName(userName, pageRequest);
    }

	@Override
    public List<TiaDocument> findByUserName(String userName) {
        return metaDocRepo.findByUserName(userName);
    }

}
