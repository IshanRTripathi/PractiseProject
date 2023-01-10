import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IG {
    public static void main(String[] args) {
        List<String> list = List.of("ishan", "ig", "abcf");
        Collections.sort(list, (a,b) -> {
            return a.length() - b.length();
        });

        System.out.println(list);

        List<Employee> employees = new ArrayList<>();
    }
}

class Employee implements Comparable {

    String empName;

    @Override
    public int compareTo(Object o) {
        Employee e = (Employee) o;
        return this.empName.length() - e.empName.length();
    }
}
