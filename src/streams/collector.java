package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class collector {
    public static void main(String[] args){
        List<String> str=new ArrayList<>(List.of("John", "Alice", "Bob", "Alexander",
                "David", "Anna", "Bob", "John"));

        //convert names of length is more than 4 and to uppercase
        List<String>res= str.stream()
                .filter(x->x.length()>4)
                .map(String::toUpperCase)
                .distinct()
                .sorted((a,b)->a.length()-b.length())
                .collect(Collectors.toList());
        print(res);
        res.clear();

        String t=str.stream()
                .collect(Collectors.joining(", "));
        System.out.println(t);

        Map<String,Integer>mp =str.stream()
                .distinct()
                .collect(Collectors.toMap(x->x, String::length));
        System.out.println(mp);
    }

    static <T> void print(List<T>list){
        list.forEach(System.out::println);
    }
}
