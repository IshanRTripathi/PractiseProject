import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/*
PROBLEM 1
You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, and an integer k. You should apply the following operation exactly k times:

Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).

Input: piles = [5,4,9], k = 2
Output: 12
Explanation: Steps of a possible scenario are:
- Apply the operation on pile 2. The resulting piles are [5,4,5].
- Apply the operation on pile 0. The resulting piles are [3,4,5].
The total number of stones in [3,4,5] is 12.
* */
public class MinimumStonesInBag {
    public static void main(String[] args) {
        MinimumStonesInBag minimumStonesInBag = new MinimumStonesInBag();

        int[] arr1 = {5,4,9};
        int[] arr2 = new int[]{1,2,3,4};
        var response1 = minimumStonesInBag.findMinStonesInBag(arr1, 2);
        var response2 = minimumStonesInBag.findMinStonesInBag(arr2, 4);
        System.out.println(response1);
        System.out.println(response2);
    }

    private int findMinStonesInBag(int[] stones, int k) {
        if(k<=0 || stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones) {
            maxHeap.add(stone);
        }
        System.out.println("Current heap: " + maxHeap);

        while(k>0 && !maxHeap.isEmpty()) {
            Integer maxStone = maxHeap.remove();
            System.out.println("Removed stone: " + maxStone + " for k: " + k);
            maxStone -= (int) Math.floor(maxStone/2);
            if(maxStone > 0) {
                maxHeap.add(maxStone);
                System.out.println("Adding back to heap: " + maxStone);
            }
            k--;
        }
        System.out.println("Heap after processing: " + maxHeap);
        int totalWeight = 0;
        while(!maxHeap.isEmpty()) {
            totalWeight += maxHeap.remove();
        }
        return totalWeight;
    }
}
