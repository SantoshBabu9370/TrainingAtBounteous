
import Modules.Employee;
import Modules.Task;
import service.TaskManager;
import service.TaskMonitor;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        TaskMonitor monitor = new TaskMonitor(manager);
        monitor.start();

        Employee emp1 = new Employee(1, "Alice", "Engineering");
        Employee emp2 = new Employee(2, "Bob", "Marketing");

        Task task1 = new Task(101, "Finish module", Task.Status.PENDING, LocalDate.now().plusDays(1), 2);
        Task task2 = new Task(102, "Update docs", Task.Status.IN_PROGRESS, LocalDate.now().minusDays(1), 1);

        manager.assignTask(emp1, task1);
        manager.assignTask(emp1, task2);

        System.out.println(manager.searchTasks("module"));
    }
}
