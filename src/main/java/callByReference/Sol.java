package callByReference;

public class Sol {
    public static void main(String[] args) {
        String a = "ishan";
        String b = new String("ishan");
        String c = a;

        System.out.println(a == b   );
        System.out.println(a == c   );
        System.out.println(b.equals(c) );




        var x = new int[]{1,2,3};
    }
}
