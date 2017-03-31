package com.springboot.service.impl;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.springboot.model.MetaDocuments;
import com.springboot.model.MetaDocuments.MetaDocument;
import com.springboot.service.MetaDocReaderService;

@Service
public class MetaDocReaderServiceImpl implements MetaDocReaderService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${metaData.xml.path}")
	String metaDataXmlFile;
	
	private MetaDocuments metaDocs;

	@Override
	public MetaDocuments loadMetaDataDoc() {
		File file = new File("file/input/Sample.xml");
		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(MetaDocuments.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			metaDocs = (MetaDocuments) jaxbUnmarshaller.unmarshal(file);
			logger.info(metaDocs.toString());
		} catch (JAXBException jaxbEx) {
			logger.error("Jaxb error", jaxbEx);
		}
		
		return metaDocs;
	}


	@Override
	public List<MetaDocument> getMetaDocuments() {
		if(metaDocs == null)
			return null;
		else
			return metaDocs.getMetaDocument();
	}
}
