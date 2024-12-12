package com.example.demo.service;


import com.example.demo.models.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
private final TaskRepository taskRepository;
public TaskService(TaskRepository taskRepository) {
this.taskRepository = taskRepository;
}
public List<Task> getAllTasks() {
return taskRepository.findAll();
}
public Task getTaskById(Long id) {
return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
}
public Task createTask(Task task) {
return taskRepository.save(task);
}

public Task updateTask(Long id, Task task) {
    Task existingTask = getTaskById(id);
    existingTask.setTitle(task.getTitle());
    existingTask.setCompleted(task.isCompleted());
    return taskRepository.save(existingTask);
    }
    public void deleteTask(Long id) {
    taskRepository.deleteById(id);
    }
}
