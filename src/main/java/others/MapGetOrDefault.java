package others;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapGetOrDefault {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "ishan");
        map.put("designation", "engineer");
        System.out.println("Initial contents: "+ map);

        // if key is not present getOrDefault still adds new key, value
        map.put("address", map.getOrDefault("address", "gorakhpur"));
        System.out.println("After using map.getOrDefault: "+ map);

        // map.getOrDefault doesnot replace value if there's already a key with a value, could be null value as well,
        // it will only replace when there's no key present
        map.put("trace", null);
        map.put("trace", map.getOrDefault("trace", "tracevalue"));
        System.out.println("After putting null as value for key trace: "+ map);

        map.replace("trace", null, "tracevalue");
        System.out.println("After using replace: "+ map);

        map.replace("trace2", null, "unknown2"); // printing after this line, there wont be any key called trsce2
        map.put("trace2", map.getOrDefault("tarce2", "unknown2")); // after this line, there will be a key called trce2 with vlue unknown2
        System.out.println("After doing replace on absent value "+ map);
    }
}
