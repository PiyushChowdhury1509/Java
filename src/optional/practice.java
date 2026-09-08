package optional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class practice {
    public static void main(String[] args){

        //level 1

        Optional<Employee> employee = Optional.of(
                new Employee("piyush", "IT", null)
        );
        employee.map(x->x.name).ifPresent(System.out::println);
        employee.map((x->x.department.toUpperCase())).ifPresent(System.out::println);
        employee.map(x->x.salary).ifPresentOrElse(System.out::println, ()-> System.out.println("salary not present"));
        employee.map(x->x.salary).filter(x->x>80000).ifPresent(System.out::println);




        //level 3

        List<Employee> emp = List.of(
                new Employee("John", "IT", 70000),
                new Employee("Bob", "IT", 95000),
                new Employee("Alice", "HR", 80000),
                new Employee("David", "HR", 75000),
                new Employee("Charlie", "Finance", 90000)
        );

        //Find the employee whose name is "Bob".
        emp.stream()
                .filter(x->x.name.equals("Bob"))
                .findFirst()
                .ifPresent(System.out::println);

        //Find the highest-paid employee and return only their name.
        emp.stream()
                .max(Comparator.comparingInt(a->a.salary))
                .map(x->x.name)
                .ifPresent(System.out::println);


        //Find the first employee belonging to "HR".
        emp.stream()
                .filter(x->x.department.equals("HR"))
                .findFirst()
                .map(x->x.name)
                .ifPresent(System.out::println);



        //level 4

        //Find the employee with the second-highest salary.
        emp.stream()
                .sorted(Comparator.comparingInt(a-> a.salary))
                .skip(1)
                .findFirst()
                .map(x->x.name)
                .ifPresent(System.out::println);

        //employee earning second highest distinct salary
        Optional<Integer>salary=emp.stream()
                .map(x->x.salary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        emp.stream()
                .filter(x->x.salary.equals(salary.orElse(-1)))
                .findFirst()
                .map(x->x.name)
                .ifPresent(System.out::println);


        //interview problem

        List<Employee> employ = List.of(
                new Employee("John", "IT", 70000),
                new Employee("Bob", "IT", 95000),
                new Employee("Alice", "HR", 80000),
                new Employee("David", "HR", 75000),
                new Employee("Charlie", "Finance", 90000)
        );
        Optional<String> a= findHighestPaidEmployee(employ, "Sales");
        System.out.println(a.orElse("name not there"));
        Optional<String> b= findHighestPaidEmployee(employ, "IT");
        System.out.println(b.orElse("name not there"));

    }

    static Optional<String> findHighestPaidEmployee(
            List<Employee>employ,
            String department
    ) {
        return employ.stream()
                .filter(x->x.department.equals(department))
                .max(Comparator.comparingInt((Employee a)->a.salary))
                .map(x->x.name);
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
