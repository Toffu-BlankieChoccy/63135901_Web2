package tech.toffu.business_web_app_project.services;

import java.util.List;
import org.springframework.data.domain.Page;
import tech.toffu.business_web_app_project.models.Task;

public interface TaskService {
    List<Task> getAllTasks();

    void saveTask(Task task);

    Task getTaskById(long id);

    void deleteTaskById(long id);

    Page<Task> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
