package tech.toffu.business_web_app_project.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long documentId;

    @Column(name = "document_name")
    private String documentName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "upload_date")
    private Date uploadDate;

    @Column(name = "file_path")
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "uploaded_by")
    private Employee uploadedBy;

    // Getters and setters
    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Employee getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(Employee uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

}
