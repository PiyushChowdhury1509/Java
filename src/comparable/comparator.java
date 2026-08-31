package comparable;

import java.util.*;

public class comparator {
    public static void main(String[] args){
        List<CollegeStudent> list= new ArrayList<>();
        list.add(new CollegeStudent(1,"piyush",90));
        list.add(new CollegeStudent(1,"ayush",99));
        list.add(new CollegeStudent(3,"ram",80));
        list.add(new CollegeStudent(4,"sonali",70));
        list.add(new CollegeStudent(5,"biju",60));

        Collections.sort(list,new IdCompare());
        print(list);
        Collections.sort(list, new NameCompare());
        print(list);
        Collections.sort(list,(a,b) -> {
            if(a.marks==b.marks) return Integer.compare(a.id,b.id);
            return Double.compare(a.marks,b.marks);
        });
        print(list);
        Comparator<CollegeStudent> compareMarks = (a,b) -> {
            if(a.marks==b.marks) return a.name.compareTo(b.name);
            return Double.compare(b.marks,a.marks);
        };
        Collections.sort(list,compareMarks);
        print(list);
    }

    static void print(List<CollegeStudent>list){
        for(CollegeStudent st: list){
            System.out.println(st.id+" "+st.name+" "+st.marks);
        }
        System.out.println();
    }
}

class IdCompare implements Comparator<CollegeStudent> {
    @Override
    public int compare(CollegeStudent a, CollegeStudent b){
        return a.id-b.id;
    }
}

class NameCompare implements Comparator<CollegeStudent> {
    @Override
    public int compare(CollegeStudent a, CollegeStudent b){
        return a.name.compareTo(b.name);
    }
}

class CollegeStudent{
    int id;
    String name;
    double marks;

    CollegeStudent(int id){
        this(id,"default");
    }
    CollegeStudent(int id, String name){
        this(id,name,0);
    }
    CollegeStudent(int id, String name, double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
}
