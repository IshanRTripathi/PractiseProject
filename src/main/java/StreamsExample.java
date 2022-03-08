import java.util.List;

public class StreamsExample {
    public static void main(String[] args) {
        List<String> names = List.of("ishan", "aditi", "sooraj", "rasagna");
//        filteredNames(names);
        names.stream().filter(name -> name.length() >5).forEach(name -> System.out.println(name));
    }

    private static void filteredNames(List<String> names) {
        for( String name: names) {
            if(name.length() > 5){
                System.out.println(name);
            }
        }
    }
}
