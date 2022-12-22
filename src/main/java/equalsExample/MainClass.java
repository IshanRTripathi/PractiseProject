package equalsExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainClass {
    public static void main(String[] args) {
        Pair p1= new Pair(1,1);
        Pair p2= new Pair(1,1);
        Pair p3= new Pair(2,2);

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));
        System.out.println("Hashcode: "+ p1.hashCode()+", "+ p2.hashCode()+", "+ p3.hashCode());

        System.out.println("========================================================================================");

        PairWithEqualsAndHashcode p4= new PairWithEqualsAndHashcode(1,1);
        PairWithEqualsAndHashcode p5= new PairWithEqualsAndHashcode(1,1);
        PairWithEqualsAndHashcode p6= new PairWithEqualsAndHashcode(2,2);

        System.out.println(p4.equals(p5));
        System.out.println(p5.equals(p6));
        System.out.println(p4.equals(p6));
        System.out.println("Hashcode: "+ p4.hashCode()+", "+ p5.hashCode()+", "+ p6.hashCode());

        System.out.println("========================================================================================");


        Set<PairWithEqualsAndHashcode> set = new HashSet<>();
        set.add(p4);
        set.add(p5);
        System.out.println(set);


        Set<Pair> set2 = new HashSet<>();
        set2.add(p1);
        set2.add(p2);
        System.out.println(set2);
    }
}
