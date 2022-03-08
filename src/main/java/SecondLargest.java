import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class SecondLargest {

    public static void findSecondLargest(String[] strArr) {
        int arr_size = strArr.length;
        BigInteger arr[] = new BigInteger[arr_size];
        int count=0;
        for (String str :strArr) {
            if (str.length()>1024){
                System.out.println("The second largest element is " + (-1));
                return;
            }
            arr[count]  = new BigInteger(str);
            count++;
        }
        BigInteger first, second;
        if (arr_size < 2) {
            System.out.println("The second largest element is " + (-1));
            return;
        }

        if (arr[0].compareTo(arr[1])>0){
            first = arr[0];
            second = arr[1];
        }else {
            first = arr[1];
            second = arr[0];
        }

        for (int i = 2; i < arr_size; i++) {
            if (arr[i].compareTo(first)<0) {
                second = first;
                first = arr[i];
            }

            else if (arr[i].compareTo(second)>0 && arr[i].compareTo(first)!=0) {
                second = arr[i];
            }
        }

        if (first.equals(second)) {
            System.out.println("The second largest element is " + (-1));
        } else {
            System.out.println("The second largest element is " + second);
        }
    }

    public static void main(String[] args) {
        String[] nums1 = {"5", "5", "4", "2"};
        String[] nums2 = {"3", "-2"};
        String[] nums3 = {"4", "4", "4"};
        String[] nums4 = {"-214748364801","-214748364802"};
        String[] nums5 = {};
        String[] nums6 = {"32765376537653427653247635427235647324657326573265", "434234", "327653765376534276532476354272356473414421324657326573265"};


        List<String[]> list = Arrays.asList(nums1,nums2, nums3, nums4, nums5, nums6);
        for (String[] arr : list) {
            findSecondLargest( arr);
        }
    }
}

//   Restrictions:
//       1. Time complexity should be O(n).
//       2. You are not allowed to change the array.
//       3. Maximum length of a single element can be 1024 digits.


