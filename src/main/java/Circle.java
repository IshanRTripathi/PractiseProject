import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        double pi = 3.14;
        double r = Double.parseDouble(new Scanner(System.in).nextLine());

        double cir = 2 * pi * r;
        double area = pi * r * r;

        System.out.println("Circumference: " + cir);
        System.out.println("Area: " + area);
    }
}
