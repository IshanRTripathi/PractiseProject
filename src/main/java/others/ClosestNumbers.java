package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(4, 2, 1, 3));
        closestNumbers(list);
    }
    public static void closestNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        int min=Integer.MAX_VALUE;
        for(int i=1; i<numbers.size(); i++) {
            min= Math.min(min, numbers.get(i)-numbers.get(i-1));
        }

        for(int i=0; i<numbers.size(); i++) {
            for(int j=i+1; j<numbers.size(); j++) {
                int diff = Math.abs(numbers.get(i)-numbers.get(j));
                if(diff > min) {
                    break;
                }
                if(diff == min) {
                    System.out.println(numbers.get(i)+" "+numbers.get(j));
                }
            }
        }
    }
}
