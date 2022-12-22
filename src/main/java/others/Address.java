package others;

import java.util.Objects;

import lombok.Getter;

@Getter
public class Address {
    String addr;

    public void setAddr(String str){
        this.addr = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(addr, address.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addr);
    }
}
