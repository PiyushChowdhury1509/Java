package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class terminals {
    public static void main(String[] args){
        List<Integer> v=new ArrayList<>(List.of(10,2,3,4,5,6));

        Boolean a= v.stream()
                .anyMatch(x->x>3);
        Optional<Integer> b= v.stream()
                .findFirst();
        Integer c= v.stream()
                .findAny().get();

        int sum=v.stream()
                .reduce(0,(x,y)->x+y);
        System.out.println(a+" "+b.get()+" "+c);
        Optional<Integer>prod=v.stream()
                .reduce((x,y)->x*y);
        prod.ifPresent(System.out::println);

        List<Integer>num=v.stream()
                .filter(x->x%2==0)
                .collect(Collectors.toList());
        num.add(-99);
        num.forEach(System.out::println);
    }
}
