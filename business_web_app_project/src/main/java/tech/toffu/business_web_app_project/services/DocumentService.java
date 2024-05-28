package tech.toffu.business_web_app_project.services;

import java.util.List;

import org.springframework.data.domain.Page;

import tech.toffu.business_web_app_project.models.Document;

public interface DocumentService {
    List<Document> getAllDocuments();

    Document saveDocument(Document document);

    Document getDocumentById(Long id);

    void deleteDocumentById(Long id);

    Page<Document> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
