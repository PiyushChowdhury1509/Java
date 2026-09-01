package streams.interviewProblems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class findDuplicateNumbers {
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(1,2,3,4,2,5,3,6,1);
        List<Integer>duplicates= nums.stream()
                .collect(Collectors.groupingBy(x->x))
                .entrySet()
                .stream()
                .filter(x->x.getValue().size()>1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(duplicates);
    }
}
