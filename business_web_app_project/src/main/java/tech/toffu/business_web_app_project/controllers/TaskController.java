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

import tech.toffu.business_web_app_project.models.Employee;
import tech.toffu.business_web_app_project.models.Status;
import tech.toffu.business_web_app_project.models.Task;
import tech.toffu.business_web_app_project.services.EmployeeService;
import tech.toffu.business_web_app_project.services.StatusService;
import tech.toffu.business_web_app_project.services.TaskService;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StatusService statusService;

    @GetMapping("/task")
    public String taskPage(Model model) {
        return findPaginated(1, "taskName", "asc", model);
    }

    @GetMapping("/showNewTaskForm")
    public String showNewTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);

        List<Employee> listEmployees = employeeService.getAllEmployees();
        model.addAttribute("listEmployees", listEmployees);

        List<Status> listStatuses = statusService.getAllStatuses();
        model.addAttribute("listStatuses", listStatuses);

        return "new_task";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task) {
        // Perform validation
        Employee assignedBy = task.getAssignedBy();
        Employee assignedTo = task.getAssignedTo();

        if (assignedBy == null || assignedTo == null) {
            // Handle error: both fields must be filled
            return "redirect:/showNewTaskForm?error=missing_assigned";
        }

        // if (!assignedBy.getDepartment().equals(assignedTo.getDepartment())) {
        // // Handle error: Assigner and assignee must be in the same department
        // return "redirect:/showNewTaskForm?error=invalid_department";
        // }

        // if (assignedBy.getEmployeeRole().getRoleName().equalsIgnoreCase("Manager") &&
        // assignedBy.getId() == assignedTo.getId()) {
        // // Handle error: Manager cannot assign tasks to themselves
        // return "redirect:/showNewTaskForm?error=manager_self_assign";
        // }

        // if (!assignedBy.getEmployeeRole().getRoleName().equalsIgnoreCase("Manager")
        // &&
        // !assignedBy.getEmployeeRole().getRoleName().equalsIgnoreCase("Team Leader")
        // &&
        // assignedBy.getId() != assignedTo.getId()) {
        // // Handle error: Only Manager or Team Leader can assign tasks to others
        // return "redirect:/showNewTaskForm?error=invalid_assigner";
        // }
        taskService.saveTask(task);
        return "redirect:/task";
    }

    @GetMapping("/showFormForUpdateTask/{id}")
    public String showFormUpdate(@PathVariable(value = "id") long id, Model model) {
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);

        List<Employee> listEmployees = employeeService.getAllEmployees();
        model.addAttribute("listEmployees", listEmployees);

        List<Status> listStatuses = statusService.getAllStatuses();
        model.addAttribute("listStatuses", listStatuses);
        return "update_task";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable(value = "id") long id) {
        this.taskService.deleteTaskById(id);
        return "redirect:/task";
    }

    @GetMapping("/page2/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir, Model model) {
        int pageSize = 5;
        Page<Task> page = taskService.findPaginated(pageNo, pageSize,
                sortField, sortDir);
        List<Task> listTasks = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listTasks", listTasks);
        return "task";
    }
}
