package lambdas;

import java.util.ArrayList;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> list= new ArrayList<>(List.of("ish", "poo", "han", "oooks"));
        list.stream();
    }
}
