import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums sorted in non-decreasing order,
return an array of the squares of each number sorted in
non-decreasing order in O(n) time complexity



Example 1:

Input: nums = [-4,-1,0,3,10]Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]Output: [4,9,9,49,121]


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 * */
public class CodingQuestion {
    public static void main(String[] args) {
        var response = getSquareInSortedOrder(new int[] {-4,-1,0,3,10});
        System.out.println(Arrays.toString(response));


        var response2 = getSquareInSortedOrder(new int[] {-7,-3,2,3,11});
        System.out.println(Arrays.toString(response2));
    }

    private static int[] getSquareInSortedOrder(int[] arr) {
        if(arr == null || arr.length == 0) return new int[]{};
        int[] response = new int[arr.length];
        int l = 0, r = arr.length-1;
        int index = arr.length-1;
        while(l<=r) {
            if(Math.abs(arr[l]) > Math.abs(arr[r])) {
                // square of l, then l++;
                response[index] = arr[l] * arr[l];
                l++;
            } else {
                // square of r, then r--;
                response[index] = arr[r] * arr[r];
                r--;
            }
            index--;
        }

        return response;
    }
}
