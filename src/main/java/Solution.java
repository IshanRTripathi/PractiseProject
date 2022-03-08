import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N= sc.nextInt();
        int[] ar= new int[N];
        for(int i=0; i<N; i++){
            ar[i]= sc.nextInt();
        }
        System.out.println(calculate(N, ar));
    }

    private static int calculate(int N, int[] ar) {
        for(int i=0; i<N-1; i++){
            if(ar[i]+1!=ar[i+1]){
                return ar[i]+1;
            }
        }
        return ar[0]-1;
    }
}
