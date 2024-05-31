package tech.toffu.business_web_app_project.services;

import java.util.List;

import org.springframework.data.domain.Page;

import tech.toffu.business_web_app_project.models.Department;

public interface DepartmentService {
    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    Department getDepartmentById(long id);

    void deleteDepartmentById(long id);

    Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    List<Department> searchDepartments(String keyword);

    Page<Department> searchPaginated(String keyword, int pageNo, int pageSize, String sortField, String sortDirection);
}
