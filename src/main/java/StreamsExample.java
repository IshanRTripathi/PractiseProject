import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamsExample {
    public static void main(String[] args) {
        List<String> names = List.of("ishan", "aditi", "sooraj", "rasagna");
//        filteredNames(names);
        names.stream().filter(name -> name.length() >5).forEach(name -> System.out.println(name));
    }

    private static void filteredNames(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() != s2.length()){
                    if(s2.compareTo(s1) > 0){
                        return 23;
                    }
                }
                return s1.compareTo(s2);
            }
        });
        Collections.sort(names, String::compareTo);
        for( String name: names) {
            if(name.length() > 5){
                System.out.println(name);
            }
        }
    }
    class Sorter implements Comparable{

        @Override
        public int compareTo(Object o) {
            return this.compareTo((String) o);
        }
    }
}
