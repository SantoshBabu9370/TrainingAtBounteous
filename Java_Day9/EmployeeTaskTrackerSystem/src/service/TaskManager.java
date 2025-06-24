package service;
import Modules.Employee;
import Modules.Task;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TaskManager {
    private Map<Employee, List<Task>> employeeTasks = new HashMap<>();
    public void assignTask(Employee e, Task t) {
       if (!employeeTasks.containsKey(e)) {
       employeeTasks.put(e, new ArrayList<>());}
          employeeTasks.get(e).add(t);

    }
    public void printTasksDueTomorrow() {
        System.out.println("Tasks Due Tomorrow:");
        employeeTasks.values().stream()
                .flatMap(List::stream)
                .filter(task -> task.getDueDate().equals(LocalDate.now().plusDays(1)))
                .forEach(System.out::println);
    }
    public void printEmployeesWithMoreThanThreePendingTasks() {
        System.out.println("Employees with more than 3 pending tasks:");
        employeeTasks.entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .filter(task -> task.getStatus() == Task.Status.PENDING)
                        .count() > 3)
                .forEach(entry -> System.out.println(entry.getKey() + " has more than 3 pending tasks."));
    }
    public List<Task> getTasksByEmployee(Employee e) {
        return employeeTasks.getOrDefault(e, Collections.emptyList());
    }
    public List<Task> searchTasks(String keyword) {
        return employeeTasks.values().stream()
                .flatMap(List::stream)
                .filter(t -> t.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Task> getSortedTasks(Employee e, Comparator<Task> comparator) {
        return getTasksByEmployee(e).stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
    public Map<Employee, List<Task>> getAllTasks() {
        return employeeTasks;
    }
}
