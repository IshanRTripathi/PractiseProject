import java.util.List;
import java.util.Optional;

public class OptionalNullable {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,8,55,31,25,98,11,23);
        Optional.ofNullable(list).ifPresent(integers -> integers.forEach(integer -> System.out.println(integer)));
//        Optional.of(list).ifPresent(i);
    }
}
