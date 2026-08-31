package comparable;

import java.util.TreeSet;

public class comparable {
    public static void main(String[] args){
        TreeSet<Student> list= new TreeSet<>();
        list.add(new Student(1,"piyush",99));
        list.add(new Student(2,"ayush",99));
        list.add(new Student(3,"ram",80));
        list.add(new Student(4,"sonali",70));
        list.add(new Student(5,"biju",60));

        print(list);
    }

    static void print(TreeSet<Student>list){
        for(Student st: list){
            System.out.println(st.id+" "+st.name+" "+st.marks);
        }
    }
}

class Student implements Comparable<Student> {
    int id;
    String name;
    double marks;

    Student(int id){
        this(id,"default");
    }
    Student(int id, String name){
        this(id,name,0);
    }
    Student(int id, String name, double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }

    @Override
    public int compareTo(Student a){
        if(this.marks==a.marks){
            return this.id-a.id;
        }
        return Double.compare(this.marks,a.marks);
    }
}
