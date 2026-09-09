package exception;

import java.util.List;

public class customException {
    public static void main(String[] args){
        List<Employee> employees = List.of(
                new Employee("John", "IT", 70000),
                new Employee("Bob", "IT", 95000),
                new Employee("Alice", "HR", 80000),
                new Employee("David", "HR", 75000)
        );
        try{
            Employee f = findEmployee(employees, "Alice","HR");
            System.out.println(f.name);
            Employee e = findEmployee(employees, "Piyush","IT");
            System.out.println(e.name);
        } catch (EmployeeNotFoundException exception){
            System.err.println(exception.getMessage());
        }
    }

    static Employee findEmployee(
            List<Employee>list,
            String name,
            String department
    ) {
        return list.stream()
                .filter(x->x.department.equals(department) && x.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("employee not found: "+name));
    }
}

class Employee {
    String name;
    String department;
    Integer salary;

    Employee(String name, String department, Integer salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

class EmployeeNotFoundException extends RuntimeException {
    EmployeeNotFoundException(String message){
        super(message);
    }
}
