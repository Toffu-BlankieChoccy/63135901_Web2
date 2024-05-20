package tech.toffu.business_web_app_project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tech.toffu.business_web_app_project.models.Task;
import tech.toffu.business_web_app_project.repositories.TaskRepository;

@Service
public class TaskImp implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task) {
        this.taskRepository.save(task);

    }

    @Override
    public Task getTaskById(long task_id) {
        Optional<Task> optional = taskRepository.findById(task_id);
        Task task = null;
        if (optional.isPresent()) {
            task = optional.get();
        } else {
            throw new RuntimeException("Task not found for id : " + task_id);
        }
        return task;

    }

    @Override
    public void deleteTaskById(long task_id) {
        this.taskRepository.deleteById(task_id);
    }

    @Override
    public Page<Task> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
                : Sort.by(sortField).descending();

        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.taskRepository.findAll(pageable);
    }
}
