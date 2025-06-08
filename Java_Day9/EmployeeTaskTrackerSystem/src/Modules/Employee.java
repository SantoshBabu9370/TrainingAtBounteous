package Modules;

import java.util.Objects;
public class Employee {
    private int id;
    private String name;
    private String department;
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    @Override
    public String toString() {
        return id + ": " + name + " (" + department + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
