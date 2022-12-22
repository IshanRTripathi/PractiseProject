package interviewVector;

import java.util.HashMap;

public class FindPath {
    public static void main(String[] args) {
        int c = 12;
        HashMap b = new HashMap();
        b.put("c", c);
        HashMap a = new HashMap();
        a.put("b", b);
        HashMap obj = new HashMap();
        obj.put("a", a);

        // System.out.println(obj);
        // obj = {
        //     a: {
        //         b: {
        //             c: 12
        //         }
        //     }
        // };


          System.out.println(findPath(obj, "a:b:c")); // 12
//          System.out.println(findPath(obj, "a:b")); // {c: 12}
//          System.out.println(findPath(obj, "a:b:d")); // null
//         System.out.println(findPath(obj, "a:c")); // null
//        System.out.println(findPath(obj, "a:b:c:d:l")); // null
//        System.out.println(findPath(obj, "a:b:c:d:e:f")); // null

    }

    public static Object findPath(HashMap obj, String path) {
        if(obj == null || path == null) {
            return null;
        }
        String[] arr = path.split(":");
        int depth = arr.length;
        return helper(obj, arr, 0);
    }

    public static Object helper(HashMap obj, String[] arr, int index) {
        if(index == arr.length - 1) {
            return obj.get(arr[index]);
        }
        if (obj.get(arr[index]) == null) {
            return null;
        } else if(obj.get(arr[index]) instanceof HashMap) {
            return helper((HashMap)obj.get(arr[index]), arr, index + 1);
        } else if (index == arr.length -1) {
            return obj.get(arr[index]);
        }
        return null;
    }
}
