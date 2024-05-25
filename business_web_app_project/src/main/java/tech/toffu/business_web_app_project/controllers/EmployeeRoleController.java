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
import tech.toffu.business_web_app_project.models.EmployeeRole;
import tech.toffu.business_web_app_project.services.EmployeeRoleService;

@Controller
public class EmployeeRoleController {
    @Autowired
    private EmployeeRoleService employeeRoleService;

    @GetMapping("/employeeRole")
    public String departmentPage(Model model) {
        return findPaginated(1, "roleName", "asc", model);
    }

    @GetMapping("/showNewEmployeeRoleForm")
    public String showNewEmployeeRoleForm(Model model) {
        EmployeeRole employeeRole = new EmployeeRole();
        model.addAttribute("employeeRole", employeeRole);
        return "new_employee_role";
    }

    @PostMapping("/saveEmployeeRole")
    public String saveEmployeeRole(@ModelAttribute("employeeRole") EmployeeRole employeeRole) {
        employeeRoleService.saveEmployeeRole(employeeRole);
        return "redirect:/employeeRole";
    }

    @GetMapping("/showFormForUpdateEmployeeRole/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
        EmployeeRole employeeRole = employeeRoleService.getEmployeeRoleById(id);
        model.addAttribute("employeeRole", employeeRole);
        return "update_employee_role";
    }

    @GetMapping("/deleteEmployeeRole/{id}")
    public String deleteEmployeeRole(@PathVariable(value = "id") long id) {
        this.employeeRoleService.deleteEmployeeRoleById(id);
        return "redirect:/employeeRole";
    }

    @GetMapping("/page3/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;
        Page<EmployeeRole> page = employeeRoleService.findPaginated(pageNo, pageSize,
                sortField, sortDir);
        List<EmployeeRole> listEmployeeRoles = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployeeRoles", listEmployeeRoles);
        return "employee_role";
    }
}
