package com.springboot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.springboot.model.TiaDocument;

import java.util.List;

public interface MetaDocRepository extends ElasticsearchRepository<TiaDocument, String> {
	
	List<TiaDocument> findById(String id);
    Page<TiaDocument> findById(String id, Pageable pageable);

	List<TiaDocument> findByDocumentName(String documentName);
    Page<TiaDocument> findByDocumentName(String documentName, Pageable pageable);

    List<TiaDocument> findByUserName(String userName);
    Page<TiaDocument> findByUserName(String userName, Pageable pageable);
    
    //fileContent
    List<TiaDocument> findByRequestNumber(String requestNumber);
    Page<TiaDocument> findByRequestNumber(String requestNumber, Pageable pageable);
    
    List<TiaDocument> findByFileContent(String fileContent);
    Page<TiaDocument> findByFileContent(String fileContent, Pageable pageable);

}
