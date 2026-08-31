package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class basicsStreams {
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));

        list.stream()
                .filter(x->x>5)
                .distinct()
                .map(x->x*x)
                .sorted()
                .forEach(System.out::println);

        Stream.iterate(0,x->x+1)
                .skip(3)
                .limit(10)
                .forEach(System.out::println);
        long count = list.stream()
                .filter(x->x>8)
                .count();
        Optional<Integer>minm = list.stream()
                        .min(Integer::compare);
        System.out.println(count+" "+minm.get());
    }
}
