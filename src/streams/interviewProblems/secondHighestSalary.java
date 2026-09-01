package streams.interviewProblems;

import java.util.Arrays;
import java.util.List;

//second highest salary
public class secondHighestSalary {
    public static void main(String[] args){
        List<Integer>list = Arrays.asList(10,2,30,4,5,6,77,8,9);
        list.stream()
                .sorted((a,b)->b-a)
                .mapToInt(x->x)
                .skip(1)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
