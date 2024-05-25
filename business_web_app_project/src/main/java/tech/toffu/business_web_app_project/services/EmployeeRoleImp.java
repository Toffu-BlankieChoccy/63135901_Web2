package tech.toffu.business_web_app_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tech.toffu.business_web_app_project.models.EmployeeRole;
import tech.toffu.business_web_app_project.repositories.EmployeeRoleRepository;

@Service
public class EmployeeRoleImp implements EmployeeRoleService {
    @Autowired
    private EmployeeRoleRepository employeeRoleRepository;

    @Override
    public List<EmployeeRole> getAllEmployeeRoles() {
        return employeeRoleRepository.findAll();
    }

    @Override
    public void saveEmployeeRole(EmployeeRole employeeRole) {
        this.employeeRoleRepository.save(employeeRole);

    }

    @Override
    public EmployeeRole getEmployeeRoleById(long employeeRoleId) {
        Optional<EmployeeRole> optional = employeeRoleRepository.findById(employeeRoleId);
        EmployeeRole employeeRole = null;
        if (optional.isPresent()) {
            employeeRole = optional.get();
        } else {
            throw new RuntimeException("Role not found for id : " + employeeRoleId);
        }
        return employeeRole;
    }

    @Override
    public void deleteEmployeeRoleById(long employeeRoleId) {
        this.employeeRoleRepository.deleteById(employeeRoleId);
    }

    @Override
    public Page<EmployeeRole> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRoleRepository.findAll(pageable);
    }
}
