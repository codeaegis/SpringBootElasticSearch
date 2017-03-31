package com.springboot.service;

import java.util.List;

import com.springboot.model.MetaDocuments;

public interface MetaDocReaderService {
	public MetaDocuments loadMetaDataDoc();
	public List<MetaDocuments.MetaDocument> getMetaDocuments();
}
