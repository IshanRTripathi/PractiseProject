import java.util.List;

public class ReverseList {
    public static void main(String[] args) {
        List<Integer> list= List.of(1,2,3,4,5,6);
        int[] arr= {1,2,3,4,5,6,7};
        List<List<Integer>> queries= List.of(List.of(0,4), List.of(2,4));

        for(List<Integer> query: queries){
            swap(arr, query);
        }
        //System.out.println(list);
    }

    private static void swap(int[] arr, List<Integer> query) {
        int f= query.get(0), l= query.get(1), s= arr.length;
        for (int i=f; i<=(l-f)/2; i++){
            System.out.println("swap: "+arr[i]+" , "+arr[l-i]);
            int temp= arr[i];
            arr[i]= arr[l-i];
            arr[l-i]= temp;
        }
        for(int x: arr){
            System.out.print(x+" ");
        }
        System.out.println();
    }

}
