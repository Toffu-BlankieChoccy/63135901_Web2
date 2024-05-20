package tech.toffu.business_web_app_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.toffu.business_web_app_project.models.EmployeeRole;

@Repository
public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, Long> {

}
