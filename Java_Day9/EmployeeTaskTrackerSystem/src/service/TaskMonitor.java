package Java_Day9.EmployeeTaskTrackerSystem.src.service;
import Modules.Employee;
import Modules.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class TaskMonitor extends Thread {
    private final TaskManager taskManager;

    public TaskMonitor(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("[TaskMonitor] Checking for overdue tasks...");
            Map<Employee, List<Task>> allTasks = taskManager.getAllTasks();

            allTasks.forEach((employee, tasks) -> {
                tasks.stream()
                        .filter(task -> task.getDueDate().isBefore(LocalDate.now()) && task.getStatus() != Task.Status.COMPLETED)
                        .forEach(task -> System.out.println("Overdue Task for " + employee + ": " + task));
            });

            try {
                Thread.sleep(60000); // every 1 minute
            } catch (InterruptedException e) {
                System.out.println("TaskMonitor interrupted.");
            }
        }
    }
}
