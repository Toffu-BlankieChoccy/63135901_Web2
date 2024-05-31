package tech.toffu.business_web_app_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tech.toffu.business_web_app_project.models.Department;
import tech.toffu.business_web_app_project.services.DepartmentService;

@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public String departmentPage(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        return findPaginated(1, "departmentName", "asc", "", model);
    }

    @GetMapping("/showNewDepartmentForm")
    public String showNewDepartmentForm(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "new_department";
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        // Save department to database
        departmentService.saveDepartment(department);
        return "redirect:/department";
    }

    @GetMapping("/showFormForUpdateDepartment/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
        Department department = departmentService.getDepartmentById(id);
        model.addAttribute("department", department);
        return "update_department";
    }

    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable(value = "id") long id) {
        this.departmentService.deleteDepartmentById(id);
        return "redirect:/department";
    }

    @GetMapping("/page1/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir,
            @RequestParam(value = "keyword", required = false) String keyword,
            Model model) {
        int pageSize = 5;
        Page<Department> page;

        if (keyword != null && !keyword.isEmpty()) {
            page = departmentService.searchPaginated(keyword, pageNo, pageSize, sortField, sortDir);
        } else {
            page = departmentService.findPaginated(pageNo, pageSize, sortField, sortDir);
        }

        List<Department> listDepartments = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listDepartments", listDepartments);
        model.addAttribute("keyword", keyword);

        return "department";
    }

    @GetMapping("/searchDepartment")
    public String searchDepartments(@RequestParam("keyword") String keyword, Model model) {
        return findPaginated(1, "departmentName", "asc", keyword, model);
    }
}
