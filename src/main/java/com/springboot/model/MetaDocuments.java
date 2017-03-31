package com.springboot.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "metaDocument"
})
@XmlRootElement(name = "MetaDocuments")
public class MetaDocuments {

    @XmlElement(name = "MetaDocument")
    protected List<MetaDocuments.MetaDocument> metaDocument;

    public List<MetaDocuments.MetaDocument> getMetaDocument() {
        if (metaDocument == null) {
            metaDocument = new ArrayList<MetaDocuments.MetaDocument>();
        }
        return this.metaDocument;
    }
    
    @Override
	public String toString() {
		return "MetaDocuments [metaDocument=" + metaDocument + "]";
	}

	@XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
    	"objectPid",
        "documentName",
        "userName",
        "sysTimestamp",
        "seqNumber",
        "requestNumber"
    })
    public static class MetaDocument {
    	@XmlElement(name = "Object_Pid", required = true)
        protected String objectPid;
        @XmlElement(name = "Document_Name", required = true)
        protected String documentName;
        @XmlElement(name = "User_Name", required = true)
        protected String userName;
        @XmlElement(name = "Sys_Timestamp", required = true)
        protected String sysTimestamp;
        @XmlElement(name = "Seq_Number", required = true)
        protected String seqNumber;
        @XmlElement(name = "request_Number", required = true)
        protected String requestNumber;
        
        @XmlTransient
        protected byte[] fileObject;
        
        @Override
		public String toString() {
			return "MetaDocument [objectPid=" + objectPid + ", documentName=" + documentName + ", userName=" + userName + ", sysTimestamp=" + sysTimestamp + ", seqNumber=" + seqNumber + ", tiaRequestNumber=" + requestNumber + ", fileObject=" + Arrays.toString(fileObject) + "]";
		}

		public String getObjectPid() {
			return objectPid;
		}

		public void setObjectPid(String objectPid) {
			this.objectPid = objectPid;
		}

		public byte[] getFileObject() {
			return fileObject;
		}

		public void setFileObject(byte[] fileObject) {
			this.fileObject = fileObject;
		}

        public String getDocumentName() {
            return documentName;
        }

        public void setDocumentName(String value) {
            this.documentName = value;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String value) {
            this.userName = value;
        }

        public String getSysTimestamp() {
            return sysTimestamp;
        }

        public void setSysTimestamp(String value) {
            this.sysTimestamp = value;
        }

        public String getSeqNumber() {
            return seqNumber;
        }

        public void setSeqNumber(String value) {
            this.seqNumber = value;
        }

        public String getRequestNumber() {
            return requestNumber;
        }

        public void setRequestNumber(String value) {
            this.requestNumber = value;
        }

    }

}
