package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class partitioningBy {
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, List<Integer>> mp=  nums.stream()
                .collect(Collectors.partitioningBy(x->x%2==0));
        print(mp);
    }

    static <U,T> void print(Map<U,T>mp){
        for(Map.Entry<U,T>entry: mp.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println();
    }
}
