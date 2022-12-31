public class MultiplyStrings {
    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        var res = multiplyStrings.multiply("123", "456");
        System.out.println(res);
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        StringBuilder prev = new StringBuilder();

        for(int i = num2.length()-1; i>=0; i--) {
            StringBuilder curr = new StringBuilder();
            int carry =0;
            for(int z =0; z < num2.length() - i - 1; z++) {
                curr.append(0);
            }
            // System.out.println("Statrting current value with: " + curr.toString());
            for(int j= num1.length()-1; j>=0; j--) {
                int product = carry + ((num1.charAt(j)-'0')*(num2.charAt(i)-'0'));
                carry = product/10;
                product = product%10;
                curr.append(product);
            }
            if(carry != 0) curr.append(carry);
            // System.out.println("Adding prev: " + prev.toString() + " and current: " + curr.toString());
            if(prev.length() > 0) {
                prev = add(prev, curr);
            } else {
                prev = curr;
            }
            // System.out.println("New prev: " + prev.toString());
        }
        return prev.reverse().toString();
    }

    StringBuilder add(StringBuilder prev, StringBuilder curr) {
        int carry = 0;
        int i =0, j = 0;
        // System.out.println("Adding " + prev.toString() + " and " + curr.toString());
        StringBuilder added = new StringBuilder();
        while(i<prev.length() && j<curr.length()) {
            int sum = (prev.charAt(i)-'0') + (curr.charAt(j)-'0') + carry;
            carry = sum/10;
            sum = sum%10;
            added.append(sum);
            i++;
            j++;
        }
        while(i<prev.length()) {
            int sum = (prev.charAt(i++)-'0') + carry;
            carry = sum/10;
            sum%=10;
            added.append(sum);
        }
        while(j<curr.length()) {
            int sum = (curr.charAt(j++)-'0') + carry;
            carry = sum/10;
            sum%=10;
            added.append(sum);
        }
        if(carry !=0 ) added.append(carry);
        return added;
    }
}