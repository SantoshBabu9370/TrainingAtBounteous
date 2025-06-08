package Modules;

import java.time.LocalDate;

public class Task implements Comparable<Task> {
    public enum Status { PENDING, IN_PROGRESS, COMPLETED }

    private int id;
    private String description;
    private Status status;
    private LocalDate dueDate;
    private int priority; // 1 (high) to 5 (low)

    public Task(int id, String description, Status status, LocalDate dueDate, int priority) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public Status getStatus() { return status; }
    public LocalDate getDueDate() { return dueDate; }
    public int getPriority() { return priority; }
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority); // lower = higher priority
    }

    @Override
    public String toString() {
        return id + ": " + description + " [" + status + "] due: " + dueDate + " (Priority: " + priority + ")";
    }
}

