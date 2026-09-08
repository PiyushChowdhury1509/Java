package optional;

import java.util.Optional;

public class basics {
    public static void main(String[] args){
        Optional<String>s=Optional.ofNullable("Piyush");
        s.ifPresent(System.out::println);
        String t=s.orElse("ayush");
        System.out.println(t);
        s.ifPresentOrElse(System.out::println, ()->System.out.println("no user found"));
        String a=s.orElseGet(()->"guest-"+Math.random());
        s.map(String::toUpperCase).ifPresent(System.out::println);
    }
}
