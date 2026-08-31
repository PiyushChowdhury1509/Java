package lambdas;

import java.util.function.*;

public class FourLambdas {
    public static void main(String[] args){

        Function<Integer,Integer> add=(a)-> a+a;
        System.out.println(add.apply(5));

        Consumer<String> printer=a-> System.out.println("My name is "+a);
        printer.accept("Piyush");

        Supplier<Double> randomGenerator= ()->Math.random();
        System.out.println(randomGenerator.get());

        Predicate<String> isStringEmpty= s -> (s.isEmpty());
        System.out.println(isStringEmpty.test("gg"));
    }
}
