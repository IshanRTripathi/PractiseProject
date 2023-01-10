import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SubstringQuestion {
    public static void main(String[] args) {
        String input = "MaN";
        String input2 = "MaNIshanR";

        System.out.println(findSubstringsWithCapitalBoundaries(input2));

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
