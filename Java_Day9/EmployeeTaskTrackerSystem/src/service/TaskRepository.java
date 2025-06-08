package service;

import Exceptions.TaskNotFoundException;
import Modules.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository<T> {
    private List<T> taskList = new ArrayList<>();

    public void add(T task) {
        taskList.add(task);
    }

    public boolean remove(T task) {
        return taskList.remove(task);
    }

    public List<T> getAll() {
        return new ArrayList<>(taskList);
    }

    public T findById(int id) throws Exception {
        for (T task : taskList) {
            if (task instanceof Task && ((Task) task).getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task with id " + id + " not found.");
    }
}
