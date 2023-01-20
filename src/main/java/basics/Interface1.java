package basics;

public interface Interface1 {
    static void doSomething(String msg) {

    }

    default void doSomethingInterface(String msg) {
        System.out.println(msg);
    }

    void show(String msg);
}
