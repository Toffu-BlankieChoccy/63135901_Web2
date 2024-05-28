package tech.toffu.business_web_app_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.toffu.business_web_app_project.models.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}