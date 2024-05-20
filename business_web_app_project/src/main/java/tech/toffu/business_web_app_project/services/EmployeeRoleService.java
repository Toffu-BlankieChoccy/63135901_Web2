package tech.toffu.business_web_app_project.services;

import java.util.List;

import org.springframework.data.domain.Page;
import tech.toffu.business_web_app_project.models.EmployeeRole;

public interface EmployeeRoleService {
    List<EmployeeRole> getAllEmployeeRoles();

    void saveEmployeeRole(EmployeeRole employeeRole);

    EmployeeRole getEmployeeRoleById(long id);

    void deleteEmployeeRoleById(long id);

    Page<EmployeeRole> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
