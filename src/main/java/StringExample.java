import java.util.List;

public class StringExample {
    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.hashCode());
        stringBuilder.append("ishan");
        System.out.println(stringBuilder.hashCode());
        stringBuilder.append(" r");
        System.out.println(stringBuilder.hashCode());


        System.out.println("=========");
        String str = "ishan";
        System.out.println(str.hashCode());
        str+= " r";
        System.out.println(str.hashCode());

        List<String> mylist= List.of("ishan", "pooks", "prachi", "ishuuuuuuuuu", "patlu", "sdfuhaiugf");
        for(int i=0; i<mylist.size(); i++) {
            if(mylist.get(i).length()%2==0) {
                System.out.println(mylist.get(i));
            }
        }
        System.out.println("==========================\n");
        mylist.stream().filter(name -> name.length()%2==0).forEach(System.out::println);
    }
}
