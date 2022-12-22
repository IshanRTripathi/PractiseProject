import java.util.*;
public class Gap_subsequence {

    public static int find_gapSum(int S[], int gap[], int index, int n, int memo[], List<Integer> ds, List<List<Integer>> result, int depth){

        if(index >= n) {
            result.add(new ArrayList<>(ds));
            return 0;
        }

        if(memo[index] != -1) return memo[index];

        ds.add(index);

        int take = S[index] + find_gapSum(S, gap, index + gap[index] + 1, n, memo, ds, result, depth +1);
        String str ="";
        for(int i=0; i<= depth; i++)
            str+= "=> ";
        System.out.println(str + " - "+ S[index]);
        ds.remove(ds.size()-1);

        int not_take = 0 + find_gapSum(S, gap, index + 1, n, memo, ds, result, depth);
        return memo[index] =  Math.max(take, not_take);


    }
    public static void main(String args[]){//MY fav monjulika....Arshin is a very good girl.she is my fav human.<3<3:)
//I'll always tease her in a fun way...She is intelligent,kind and a good friend. She is self obsessed.
//She has a cute smile and a cute plus weird laughter.
// Ik her voice is not that good but she is wonderful human.Her hair is beautiful. He eye has unique color.
//        int arr[] = {4,2,1,3,5,3};
//        int gap[] = {1,2,1,2,9,1};
        int arr[] = {4,2,1,3,5,3};
        int gap[] = {1,2,1,2,9,1};
        int n = arr.length;

        int memo [] = new int[n];
        for(int i=0; i<n; i++){
            memo[i] = -1;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> ds = new ArrayList<>();

        //sub(0, nums, ds, res);
        int res = find_gapSum(arr, gap, 0, n, memo, ds, result, 0);
        System.out.println("Gap Sum = " + res);
        System.out.println("The indices are : ");

        for(int i : memo)
        {
            System.out.println(i + ", ");
        }
    }
}