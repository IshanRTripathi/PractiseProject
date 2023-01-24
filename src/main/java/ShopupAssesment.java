import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ShopupAssesment {
    public static void main(String[] args) {
        List<int[]> input =  new ArrayList<>(List.of(new int[]{10,2}, new int[]{0,8}, new int[]{4, 2}, new int[]{7,3}, new int[]{12, 8}, new int[]{15, 4}));
        Collections.sort(input, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize variables to track the current time and total waiting time
        int currentTime = 0;
        int totalWaitingTime = 0;
        List<int[]> optimizedOrder = new ArrayList<>();

        // Iterate through each element in the input
        for (int i = 0; i < input.size(); i++) {
            int[] task = input.get(i);
            int arrivalTime = task[0];
            int waitingTime = task[1];

            // If the task arrives before the current task is finished, add the waiting time
            if (arrivalTime <= currentTime) {
                totalWaitingTime += currentTime - arrivalTime + waitingTime;
                optimizedOrder.add(task);
            }

            // Update the current time to the completion time of the task
            currentTime = Math.max(currentTime, arrivalTime) + waitingTime;
        }

        // Calculate the average waiting time
        double averageWaitingTime = (double) totalWaitingTime / input.size();
        System.out.println("Average waiting time: " + averageWaitingTime);
        optimizedOrder.forEach(o -> System.out.println(Arrays.toString(o)));

    }

    private static int findNextBestCustomer(Set<Integer> indexesProcessed, List<int[]> input) {
        System.out.println("Indexes processed so far: " + indexesProcessed);
        double minAvgTime = Double.MAX_VALUE;
        int minCustomerIndex = 0;
        double minTotalWaitingTime = Double.MAX_VALUE;
        for (int i = 0; i < input.size(); i++) {
            if(indexesProcessed.contains(i)) continue;
            double totalWaitingTime = getTotalWaitingTime(input, i);
            double averageWaitingTime = totalWaitingTime/input.size();
            if(averageWaitingTime < minAvgTime) {
                minAvgTime = averageWaitingTime;
                minCustomerIndex = i;
                minTotalWaitingTime = totalWaitingTime;
            }
        }
        System.out.println("Current customer at index" +minCustomerIndex+ " arrived at: "+ input.get(minCustomerIndex)[0] + " with waiting time: "
            + input.get(minCustomerIndex)[1]);
        return minCustomerIndex;
    }

    private static double getTotalWaitingTime(List<int[]> input, int index) {
        int currentTime = 0;
        int totalWaitingTime = 0;
        int[] task = input.get(index);
        int arrivalTime = task[0];
        int waitingTime = task[1];
        // If the task arrives before the current task is finished, add the waiting time
        if (arrivalTime <= currentTime) {
            totalWaitingTime += currentTime - arrivalTime + waitingTime;
        }
        System.out.println("\t\t" + totalWaitingTime);
        return (double) totalWaitingTime;
    }
}
