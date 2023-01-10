/*
Given an array of integers, write a program that efficiently finds the second largest element present in the array.
Input: arr[] = {12, 35, 1, 10, 34, 1}
Output: The second largest element is 34
* */
public class Find2ndMax {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int[] arr2 = {35, 35};
        int[] arr3 = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        var response = findSecondMaxValue(arr);
        var response2 = findSecondMaxValue(arr2);
        var response3 = findSecondMaxValue(arr3);
        System.out.println(response);
        System.out.println(response2);
        System.out.println(response3);
    }

    private static Integer findSecondMaxValue(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        Integer firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;

        for (Integer num : arr) {
            if (num > secondMax && num < firstMax) {
                secondMax = num;
                continue;
            }
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            }
        }
        return secondMax;
    }
}
