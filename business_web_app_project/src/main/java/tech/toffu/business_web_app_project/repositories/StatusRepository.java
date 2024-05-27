package tech.toffu.business_web_app_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.toffu.business_web_app_project.models.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{

}
