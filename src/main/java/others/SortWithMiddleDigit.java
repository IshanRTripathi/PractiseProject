package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortWithMiddleDigit {
    public static void main(String[] args) {
        int[] arr= {12321, 77483, 90173, 76532, 10113, 101, 999};
        List<Integer> list = new ArrayList<>();
        for(int x: arr){
            list.add(x);
        }
        Collections.sort(list, (a,b) -> {
            char ap = a.toString().charAt(a.toString().length()/2);
            char bp = b.toString().charAt(b.toString().length()/2);
            if(ap != bp) {
                return ap-bp;
            }
            return a.compareTo(b);
        });
        for(int x: list){
//            System.out.print(x+" ");
        }
        try {
           int x= 5/0;
        } catch (ArithmeticException exception){

        } catch (Exception e) {

        }
        System.out.println(50 + 20 + "Ishan");
        System.out.println( "Ishan" +50 + 20 );
    }
}
