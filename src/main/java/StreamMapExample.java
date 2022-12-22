import java.util.ArrayList;
import java.util.List;


public class StreamMapExample {
    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>();
        Address address1= new Address("street1", "street2", "pin1");
        Address address2= new Address("street3", "street4", "pin2");
        Address address3= new Address("street4", "street6", "pin3");
        addresses.add(address1);
        addresses.add(address2);
        addresses.add(address3);
//        addresses.stream().map(address -> address.getPincode()).forEach(System.out::println);
    }
}
