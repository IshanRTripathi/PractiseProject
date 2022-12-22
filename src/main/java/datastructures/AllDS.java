package datastructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import com.google.gson.internal.LinkedHashTreeMap;

public class AllDS {
    public static void main(String[] args) {
        // Map - hashing
        Map<String, String> map = new HashMap<>();
        map.put("abc", "xyz");
        map.put("ish", "pri");
        int[] arr= new int[]{1,2,34,4,5};
        for(int x: arr) {
            map.get(x+"");
        }

        Set<String> set = new HashSet<>();
        set.add("ishan");
        set.add("pooks");
        set.add("ishan");
        System.out.println(set);

        List<String> list = new ArrayList<>();
        list.add("ishan");
        list.add("pooks");
        list.add("ishan");
        System.out.println(list);

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        };
        PriorityQueue<Integer> pq1= new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });


        pq.add("ishan");
        pq.add("pooks");
        pq.add("ishu");
        pq.add("ishuuuuuu");
        pq.add("pinguuuuuuuuuu");
        System.out.println(pq);
        pq.remove("ishuuuuuu");
        System.out.println(pq);

        ListNode head = new ListNode(1);
        head.next = new ListNode(12);
        head.next.next = new ListNode(2);

        System.out.println(head);
        deleteDuplicates(head);

        List<String> myList = new ArrayList<>(){{
            add("ishan");
            add("piuu");
            remove(1);
        }};
        System.out.println(myList);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        return new ListNode();
    }

    public static class ListNode extends Object{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
        }
    }
}
