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
import tech.toffu.business_web_app_project.models.Employee;
import tech.toffu.business_web_app_project.models.EmployeeRole;
import tech.toffu.business_web_app_project.services.DepartmentService;
import tech.toffu.business_web_app_project.services.EmployeeRoleService;
import tech.toffu.business_web_app_project.services.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private EmployeeRoleService employeeRoleService;

	@GetMapping("/")
	public String homePage(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		return findPaginated(1, "firstName", "asc", "", model);
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		List<Department> listDepartments = departmentService.getAllDepartments();
		model.addAttribute("listDepartments", listDepartments);

		List<EmployeeRole> listEmployeeRoles = employeeRoleService.getAllEmployeeRoles();
		model.addAttribute("listEmployeeRoles", listEmployeeRoles);

		return "new_employee";
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// Save employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);

		List<Department> listDepartments = departmentService.getAllDepartments();
		model.addAttribute("listDepartments", listDepartments);

		List<EmployeeRole> listEmployeeRoles = employeeRoleService.getAllEmployeeRoles();
		model.addAttribute("listEmployeeRoles", listEmployeeRoles);

		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			@RequestParam(value = "keyword", required = false) String keyword,
			Model model) {
		int pageSize = 5;
		Page<Employee> page;

		if (keyword != null && !keyword.isEmpty()) {
			page = employeeService.searchPaginated(keyword, pageNo, pageSize, sortField, sortDir);
		} else {
			page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
		}

		List<Employee> listEmployees = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listEmployees", listEmployees);
		model.addAttribute("keyword", keyword);

		return "index";
	}

	@GetMapping("/search")
	public String searchEmployees(@RequestParam("keyword") String keyword, Model model) {
		return findPaginated(1, "firstName", "asc", keyword, model);
	}
}