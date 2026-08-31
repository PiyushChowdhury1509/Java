public class generics {
    public static void main(String[] args){
        Calculator<Number, Integer> calc=new Calculator<>();
        calc.print(1,2);
        Calculator.add(2.3, 3);


        TestClass<Fish> t= new TestClass<>();
        //TestClass<Monkey> g= new TestClass<>();
    }

    public static <T> T test (T obj){
        System.out.println(obj);
        return obj;
    }
}

class Calculator<T extends Number, U extends Integer>{

    static <T,U> void add(T a, U b){ //or remove static and the t,u before void
        System.out.println(a+" "+b);
    }

    void print(T a, U b){
        System.out.println(a+"gg"+b);
    }
}

class TestClass<T extends Animal & Swimmable> {
    T object;
}

interface Swimmable {
    void swim();
}

class Animal {
    void eat(){
        System.out.println("eating...");
    }
}

class Monkey extends Animal {
    @Override
    void eat() {
        System.out.println("eating bananas");
    }
}

class Fish extends Animal implements Swimmable {
    @Override
    public void swim() {
        System.out.println("swimming");
    }
}
