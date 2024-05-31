package tech.toffu.business_web_app_project.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tech.toffu.business_web_app_project.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d FROM Department d WHERE LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(d.location) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(d.contactInformation) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Department> searchDepartments(@Param("keyword") String keyword);

    // Add this method for paginated search
    @Query("SELECT d FROM Department d WHERE LOWER(d.departmentName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(d.location) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(d.contactInformation) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Department> searchDepartments(@Param("keyword") String keyword, Pageable pageable);
}
