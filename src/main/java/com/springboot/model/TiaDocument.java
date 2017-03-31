package com.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.springboot.model.MetaDocuments.MetaDocument;

@Document(indexName = "metadocindex", type = "metadocs")
public class TiaDocument {
	
	@Id
    private String id;
    private String documentName;
    private String userName;
    private String sysTimestamp;
    private String seqNumber;
    private String requestNumber;
    private String fileContent;
	
    public TiaDocument(){};
    
    public TiaDocument(MetaDocument metaDoc) {
    	id = metaDoc.getObjectPid();
    	documentName = metaDoc.getDocumentName();
    	userName = metaDoc.getUserName();
    	sysTimestamp = metaDoc.getSysTimestamp();
    	seqNumber = metaDoc.getSeqNumber();
    	requestNumber = metaDoc.getRequestNumber();
    }
    
    
	@Override
	public String toString() {
		return "TiaDocument [id=" + id + ", documentName=" + documentName + ", userName=" + userName + ", sysTimestamp=" + sysTimestamp + ", seqNumber=" + seqNumber + ", requestNumber=" + requestNumber + ", fileContent=" + fileContent + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSysTimestamp() {
		return sysTimestamp;
	}

	public void setSysTimestamp(String sysTimestamp) {
		this.sysTimestamp = sysTimestamp;
	}

	public String getSeqNumber() {
		return seqNumber;
	}

	public void setSeqNumber(String seqNumber) {
		this.seqNumber = seqNumber;
	}

	public String getRequestNumber() {
		return requestNumber;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
}
