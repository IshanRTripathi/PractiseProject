package mystifly;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunnerClass {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(new Employee("e1", 1, "engineer"),
        new Employee("e2", 2, "sr. engineer"),
            new Employee("e3", 3, "lead engineer"),
            new Employee("e4", 4, "engineering manager"),
            new Employee("e5", 5, "engineer 2")));
//        System.out.println(employees);

        Collections.sort(employees, (a, b) -> {
            return b.employeeName.compareTo(a.employeeName);
        });

//        System.out.println(employees);


        Thread even = new Thread(new Counter());
        Thread odd = new Thread(new Counter());
        even.setName("even");
        odd.setName("odd");
        even.start();
        odd.start();
    }
}

class Counter implements Runnable {
    static int count = 0;

    @Override
    public void run() {
        while(count < 20) {

            if (count % 2 == 0 && Thread.currentThread().getName().equals("odd")) {
                count++;
                System.out.println(Thread.currentThread().getName() + " incremented the value to => " + count);
            } else if (count % 2 == 1 && Thread.currentThread().getName().equals("even")) {
                count++;
                System.out.println(Thread.currentThread().getName() + " incremented the value to => " + count);
            }
        }
    }
}