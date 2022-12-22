import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Address {
    String street1;
    String street2;
    String pincode;

    public Address(String street1, String street2, String pincode) {
        this.street1 = street1;
        this.street2 = street2;
        this.pincode = pincode;
    }
}
