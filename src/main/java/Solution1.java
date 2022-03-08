import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String input= sc.nextLine();
        System.out.println(findRepeatingCharacter(input));
    }

    private static int findRepeatingCharacter(String input) {
        int[] map= new int[256];
        int max=0;
        for(char ch: input.toCharArray()){
            map[ch]++;
            max= Math.max(max, map[ch]);
        }
        return max;
    }
}
