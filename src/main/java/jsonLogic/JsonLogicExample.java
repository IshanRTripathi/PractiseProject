package jsonLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import io.github.jamsesso.jsonlogic.JsonLogic;
import io.github.jamsesso.jsonlogic.JsonLogicException;
import jsonLogic.model.Data;

public class JsonLogicExample {
    public static void main(String[] arg) throws JsonLogicException, FileNotFoundException {
        // Create a new JsonLogic instance. JsonLogic is thread safe.
        JsonLogic jsonLogic = new JsonLogic();

        // Set up some JSON and some data.
        Map<String, Integer> data = new HashMap<>();
        data.put("x", 10);
        data.put("y", 110);

        // Evaluate the result.
        double result = (double) jsonLogic.apply(readFromLocation("src/main/java/jsonLogic/jsonFiles/input1.json"), data);
        System.out.println(result);


        List<Data> dataList = List.of(new Data("ishan"), new Data("pings"));
        // Register an operation.
        jsonLogic.addOperation("greet", objects -> "Hi "+ Arrays.stream(objects).collect(Collectors.toSet())+ " !");

        // Evaluate the result.
        String result2 = (String) jsonLogic.apply(readFromLocation("src/main/java/jsonLogic/jsonFiles/greet.json"), dataList);
        System.out.println(result2);
    }

    private static String readFromLocation(String s) throws FileNotFoundException {
        File file = new File(s);
        Scanner sc = new Scanner(file);
        StringBuilder expression = new StringBuilder();
        while (sc.hasNextLine())
            expression.append(sc.nextLine());
        return expression.toString();
    }
}
