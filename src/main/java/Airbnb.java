import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Airbnb {
    public static void main(String[] args) {
        List<List<Integer>> nodes = new ArrayList<>();
        nodes.add(List.of(17, -1, -1));
        nodes.add(List.of(15, 13, 17));
        nodes.add(List.of(7, -1, -1));
        nodes.add(List.of(13, -1, -1));
        nodes.add(List.of(5, 3, 7));
//        nodes.add(List.of(3, 4, -1));
        nodes.add(List.of(3, -1, -1));
        nodes.add(List.of(10, 5, 15));
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        int res = findRoot(nodes);
        System.out.println("Result: "+res);
    }

    private static int findRoot(List<List<Integer>> nodes) {
        Map<Integer, Set<Integer>> map = new HashMap<>(); // key will be node.data and value will be set of both child nodes if not -1
        List<Integer> allNodes = new ArrayList<>();
        int totalNodes = 0;
        int totalScannedNodes = 0;
        int possibleRootNode = -1;
        for(List<Integer> node: nodes) {
            if(map.containsKey(node.get(0))){
                return -1;
            }
            Set<Integer> values = new HashSet<>();
            for(int i=1; i<node.size() && node.get(i) != -1; i++){
                totalNodes++;
                allNodes.add(node.get(i));
                values.add(node.get(i));
            }
            map.put(node.get(0), values);
        }
        // ab check karna hai ki har key kisi ek value me present hai ya nhi
        for(Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            boolean isKeyPresent = false;
            for(Map.Entry<Integer, Set<Integer>> entry2: map.entrySet()) {
                if(!entry.getKey().equals(entry2.getKey())) {
                    if(entry2.getValue().contains(entry.getKey())) {
                        totalScannedNodes++;
                        isKeyPresent = true;
                    }
                }
            }
            if(isKeyPresent == false) {
                System.out.println(entry.getKey()+" is not present in any node");
                possibleRootNode = entry.getKey();
            } else {
                System.out.println(entry.getKey()+" is present");
            }
        }
        if(totalNodes==totalScannedNodes) {
            System.out.println("All good");
            return possibleRootNode;
        }
        return -1;
    }

    static class BSTNode {
        int value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int value, BSTNode left, BSTNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
