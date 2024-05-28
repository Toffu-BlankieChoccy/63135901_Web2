package tech.toffu.business_web_app_project.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tech.toffu.business_web_app_project.models.Document;
import tech.toffu.business_web_app_project.models.Employee;
import tech.toffu.business_web_app_project.services.DocumentService;
import tech.toffu.business_web_app_project.services.EmployeeService;

@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private EmployeeService employeeService;
    private final String uploadDir = "uploads/";

    @GetMapping("/document")
    public String viewDocuments(Model model) {
        List<Document> listDocuments = documentService.getAllDocuments();
        model.addAttribute("listDocuments", listDocuments);
        return "document";
    }

    @GetMapping("/showNewDocumentForm")
    public String showNewDocumentForm(Model model) {
        Document document = new Document();
        model.addAttribute("document", document);

        List<Employee> listEmployees = employeeService.getAllEmployees();
        model.addAttribute("listEmployees", listEmployees);

        return "new_document";
    }

    @PostMapping("/saveDocument")
    public String saveDocument(@ModelAttribute("document") Document document,
            @RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            // Handle empty file case if necessary
            return "redirect:/showNewDocumentForm?error=emptyFile";
        }

        // Save the file locally
        Path filePath = Paths.get(uploadDir, file.getOriginalFilename());
        Files.createDirectories(filePath.getParent());
        Files.write(filePath, file.getBytes());

        // Save the document details in the database
        document.setFilePath(filePath.toString());
        document.setUploadDate(Date.valueOf(LocalDate.now()));
        documentService.saveDocument(document);

        return "redirect:/document";
    }

    @GetMapping("/showFormForUpdateDocument/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
        Document document = documentService.getDocumentById(id);
        model.addAttribute("document", document);
        return "update_document";
    }

    @GetMapping("/deleteDocument/{id}")
    public String deleteDocument(@PathVariable(value = "id") long id) {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            File file = new File(document.getFilePath());
            if (file.exists()) {
                file.delete();
            }
            documentService.deleteDocumentById(id);
        }
        return "redirect:/document";
    }

    @GetMapping("/downloadDocument/{id}")
    public ResponseEntity<Resource> downloadDocument(@PathVariable(value = "id") long id) throws IOException {
        Document document = documentService.getDocumentById(id);
        if (document != null) {
            // Load the file as a resource
            Resource resource = new UrlResource(Paths.get(document.getFilePath()).toUri());

            // Check if the resource exists and is readable
            if (resource.exists() && resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                // Handle resource not found or not readable
                return ResponseEntity.notFound().build();
            }
        }
        // Handle document not found
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/page4/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;
        Page<Document> page = documentService.findPaginated(pageNo, pageSize,
                sortField, sortDir);
        List<Document> listDocuments = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listDocuments", listDocuments);
        return "document";
    }
}
