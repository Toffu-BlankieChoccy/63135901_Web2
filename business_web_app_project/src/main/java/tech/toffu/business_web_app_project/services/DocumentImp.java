package tech.toffu.business_web_app_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tech.toffu.business_web_app_project.models.Department;
import tech.toffu.business_web_app_project.models.Document;
import tech.toffu.business_web_app_project.repositories.DocumentRepository;

@Service
public class DocumentImp implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(Long documentId) {
        Optional<Document> optional = documentRepository.findById(documentId);
        Document document = null;
        if (optional.isPresent()) {
            document = optional.get();
        } else {
            throw new RuntimeException("Department not found for id : " + documentId);
        }
        return document;
    }

    @Override
    public void deleteDocumentById(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public Page<Document> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.documentRepository.findAll(pageable);
    }
}
