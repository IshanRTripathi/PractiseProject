package others;

public class EqualsExample {
    public static void main(String[] args) {
        System.out.println(1==1);
        System.out.println(Integer.valueOf(1).equals(1));
        Address address1 = new Address();
        address1.setAddr("a1");
        Address address2 = new Address();
        address2.setAddr("a2");
        System.out.println(address1==address2);
        System.out.println(address1.equals(address2));


        String str1 = new String("ishan");
        String str2 = new String("ishan");

        System.out.println(address1.hashCode());
        System.out.println(address2.hashCode());
    }
}
