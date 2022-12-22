package others;

import java.util.List;

public class MaximumRatingSum {
    public static void main(String[] args) {
        System.out.println(maxSubArraySum(List.of(-1, -2, 1, 3)));
        System.out.println(maxSubArraySum(List.of(-1, 3, 4, -2, 5, -7)));
    }
    public static long maxSubArraySum(List<Integer> arr)
    {
        int res = Integer.MIN_VALUE;
        int tempMax = 0;

        for (Integer integer : arr) {
            tempMax = tempMax + integer;
            if (res < tempMax)
                res = tempMax;
            if (tempMax < 0)
                tempMax = 0;
        }
        return res;
    }
}
