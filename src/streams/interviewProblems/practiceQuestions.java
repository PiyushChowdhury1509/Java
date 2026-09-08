package streams.interviewProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class practiceQuestions {
    public static void main(String[] args){
        List<Employee> nums = Arrays.asList(
                new Employee("John", "IT", 70000, 25),
                new Employee("Bob", "IT", 95000, 30),
                new Employee("Alice", "HR", 80000, 28),
                new Employee("David", "HR", 75000, 35),
                new Employee("Charlie", "Finance", 90000, 32),
                new Employee("Eve", "Finance", 85000, 27),
                new Employee("Frank", "IT", 95000, 26)
        );

        //level 1

        //Get the names of all employees.
        nums.stream()
                .map(x->x.name)
                .forEach(System.out::println);
        System.out.println();

        //Get all employees from the IT department.
        nums.stream()
                .filter(x->x.department.equals("IT"))
                .map(x-> x.name)
                .forEach(System.out::println);
        System.out.println();

        //Find the employee with the highest salary.
        nums.stream()
                .max((a,b)->Integer.compare(a.salary,b.salary))
                .ifPresent(System.out::println);
        System.out.println();

        //Calculate the average salary of all employees.
        nums.stream()
                .mapToInt(x->x.salary)
                .average()
                .ifPresent(System.out::println);
        System.out.println();

        //Find the total salary paid to all employees.
        int sum=nums.stream()
                .mapToInt(x->x.salary)
                .sum();
        System.out.println(sum);
        System.out.println();



        //level 2

        //Group employees by department.
        Map<String,List<String>> l= nums.stream()
                .collect(Collectors.groupingBy(x->x.department, Collectors.mapping(x->x.name, Collectors.toList())));
        printMapList(l);
        System.out.println();

        //Count the number of employees in each department.
        Map<String, Long>mp= nums.stream()
                .collect(Collectors.groupingBy(x->x.department, Collectors.counting()));
        printMapVal(mp);
        System.out.println();

        //Find the average salary of each department.
        Map<String, Double>mp2= nums.stream()
                .collect(Collectors.groupingBy(x->x.department, Collectors.averagingDouble(x->x.salary)));
        printMapVal(mp2);
        System.out.println();

        //Find the highest-paid employee in each department.
        Map<String, Optional<Employee>>mp3 = nums.stream()
                .collect(Collectors.groupingBy(x->x.department, Collectors.maxBy((a,b)->Double.compare(a.salary,b.salary))));
        print(mp3);
        System.out.println();



        //level 3

        //Find the names of employees earning more than 80000, grouped by department.
        Map<String,List<String>>mp4= nums.stream()
                .filter(x->x.salary>80000)
                .collect(Collectors.groupingBy(x->x.department,Collectors.mapping(x->x.name,Collectors.toList())));
        printMapList(mp4);
        System.out.println();


        //Find the average salary of employees older than 28.

    }

    static <U,T>void printMapList(Map<U,List<T>>mp){
        for(Map.Entry<U,List<T>>entry : mp.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }

    static <U, T> void print(Map<U, Optional<T>> mp) {
        for (Map.Entry<U, Optional<T>> entry : mp.entrySet()) {
            entry.getValue().ifPresent(value ->
                    System.out.println(entry.getKey() + " -> " + value)
            );
        }
    }

    static <U,T> void printMapVal(Map<U,T>mp){
        for(Map.Entry<U,T>entry : mp.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}

class Employee {
    String name;
    String department;
    int salary;
    int age;

    Employee(String name, String department, int salary, int age) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString(){
        String s=this.name+" "+this.department+" "+this.salary+" "+this.age;
        return s;
    }
}