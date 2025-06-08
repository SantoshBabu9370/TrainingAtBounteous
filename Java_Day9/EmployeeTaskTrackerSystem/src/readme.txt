# Employee Task Tracker System

🚀 Features
- Assign tasks to employees
- Track task status, due date, and priority
- Background thread to detect overdue tasks
- Sort/search/filter tasks using Java streams
- Custom exceptions and generic repository for task management

To compile/execute the program, run the Main class in the src.

Concepts utilised:
OOP        	       - Employee, Task, TaskManager encapsulate behavior and data
Custom Exceptions  - TaskNotFoundException when task lookup fails
Generics	       - TaskRepository<T> handles tasks in a generic way
Collections        - HashMap<Employee, List<Task>> manages assignments
Stream & Lambdas   - Searching, filtering, sorting tasks with stream(), lambda expressions
Comparable         -	Task objects sorted by priority using compareTo()
Multithreading	   - TaskMonitor class checks overdue tasks every minute using Thread


