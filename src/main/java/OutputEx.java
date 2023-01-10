public class OutputEx {
    public static void main(String[] args) {
        int ans = 0;
        for(int i = 5 ; i > 0 ; i /= 2)
        {
            for(int j = 0 ; j < i ; j++)
            {
                ans++;
            }
        }
        System.out.println( ans);
    }
}
