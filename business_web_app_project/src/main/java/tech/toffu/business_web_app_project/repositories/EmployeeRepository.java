package tech.toffu.business_web_app_project.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.toffu.business_web_app_project.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        @Query("SELECT e FROM Employee e WHERE " +
                        "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
                        "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
                        "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
        List<Employee> searchEmployees(String keyword);

        // Add this method for paginated search
        @Query("SELECT e FROM Employee e WHERE " +
                        "LOWER(e.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
                        "LOWER(e.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
                        "LOWER(e.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
        Page<Employee> searchEmployees(@Param("keyword") String keyword, Pageable pageable);
}
