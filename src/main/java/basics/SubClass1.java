package basics;

public class SubClass1 extends SuperClass implements Interface1 {

    @Override
    public void doSomethingElse(String msg) {
        super.doSomethingElse(msg);
    }

    @Override
    public void doSomethingInterface(String msg) {
        Interface1.super.doSomethingInterface(msg);
    }

    @Override
    public void show(String msg) {

    }


    // Compile time error as subclass cannot override static method
//    @Override
//    public void doSomething(String msg) {
//        super.doSomethingElse(msg);
//    }


}
