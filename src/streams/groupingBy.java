package streams;

import java.util.*;
import java.util.stream.Collectors;

public class groupingBy {
    public static void main(String[] args){
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 8),
                new Employee("Alice", "HR", 6),
                new Employee("Bob", "IT", 9),
                new Employee("David", "HR", 7),
                new Employee("Mike", "Finance", 75),
                new Employee("Sarah", "IT", 85)
        );

        //group employees by department
        Map<String,List<Employee>> mp= employees.stream()
                .collect(Collectors.groupingBy(x->x.department));
        print(mp);

        //find number of employees in each department
        Map<String,Long> mp2 = employees.stream()
                .collect(Collectors.groupingBy(x->x.department, Collectors.counting()));
        print(mp2);

        //find average salary per department
        Map<String,Double>mp3 = employees.stream()
                .collect(Collectors.groupingBy(x->x.department,Collectors.averagingDouble(x->x.salary)));
        print(mp3);

        //highest paid employee in each department
        Map<String, Optional<Employee>>mp4 = employees.stream()
                .collect(Collectors.groupingBy(x->x.department, Collectors.maxBy((a,b)->(int)a.salary-(int)b.salary)));
        print(mp4);

        //department with highest average salary
        Map<String,Double>mp5= employees.stream()
                .collect(Collectors.groupingBy(x->x.department,Collectors.averagingDouble(x->x.salary)));
        mp5.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

    }

    static <U,T> void print(Map<U,T>mp){
        for(Map.Entry<U,T>entry: mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println();
    }
}

class Employee {
    String name;
    String department;
    long salary;

    Employee(String name, String department, long salary){
        this.name=name;
        this.department=department;
        this.salary=salary;
    }

    @Override
    public String toString(){
        String s=this.name+" "+this.department+" "+this.salary;
        return s;
    }
}