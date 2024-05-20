package tech.toffu.business_web_app_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tech.toffu.business_web_app_project.models.Department;
import tech.toffu.business_web_app_project.repositories.DepartmentRepository;

@Service
public class DepartmentImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        this.departmentRepository.save(department);

    }

    @Override
    public Department getDepartmentById(long departmentId) {
        Optional<Department> optional = departmentRepository.findById(departmentId);
        Department department = null;
        if (optional.isPresent()) {
            department = optional.get();
        } else {
            throw new RuntimeException("Department not found for id : " + departmentId);
        }
        return department;

    }

    @Override
    public void deleteDepartmentById(long departmentId) {
        this.departmentRepository.deleteById(departmentId);
    }

    @Override
    public Page<Department> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.departmentRepository.findAll(pageable);
    }

}