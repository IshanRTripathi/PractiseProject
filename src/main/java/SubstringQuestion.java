import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubstringQuestion {
    public static void main(String[] args) {
        String input = "MaN";
        String input2 = "MaNIshanR";

        System.out.println(findSubstringsWithCapitalBoundaries(input2));


        List<EmployeeDetails> employeeDetails = List.of(new EmployeeDetails("1", 12345, "eng1"),
            new EmployeeDetails("2", 4567, "eng2"),
            new EmployeeDetails("3", 8765, "manager"));

        employeeDetails.stream()
            .map(EmployeeDetails::getSalary)
            .filter(salary -> salary > 5000 && salary< 10000)
            .collect(Collectors.toList());

//        select * from employee e,
//            where e.empid not in (select con.empid from contacts con)

    }

    private static List<String> findSubstringsWithCapitalBoundaries(String input) {
        if(input.isBlank()) {
            return new ArrayList<>();
        }
        int left = 0, right = 0;
        List<String> substringsWithCapitalBoundaries = new ArrayList<>();
        while(right < input.length()) {
            if(!Character.isUpperCase(input.charAt(right))) {
                right++;
                continue;
            }
            if(!Character.isUpperCase(input.charAt(left))) {
                left = right;
            }
            if(!substringsWithCapitalBoundaries.contains(input.charAt(right)+"")) {
                substringsWithCapitalBoundaries.add(input.charAt(right)+"");
            }

            String currentValidSubstring = input.substring(left, right + 1);
            for(String substring: new ArrayList<>(substringsWithCapitalBoundaries)) {
                if(input.indexOf(substring) + substring.length() == input.indexOf(currentValidSubstring))
                    substringsWithCapitalBoundaries.add(substring + currentValidSubstring);
            }
//            String str = substringsWithCapitalBoundaries.get(substringsWithCapitalBoundaries.size() - 1) + currentValidSubstring.substring(1);
//            substringsWithCapitalBoundaries.add(str);
            if(!substringsWithCapitalBoundaries.contains(currentValidSubstring))
                substringsWithCapitalBoundaries.add(currentValidSubstring);
            left = right;
            right++;
        }
        return substringsWithCapitalBoundaries;
    }
}
class EmployeeDetails {

    String empid;
    Integer salary;
    String designation;

    EmployeeDetails(String empid, Integer salary, String designation) {
        this.designation = designation;
        this.salary = salary;
        this.empid = empid;
    }

    public Integer getSalary() {
        return this.salary;
    }
}