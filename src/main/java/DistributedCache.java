import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DistributedCache {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        hashTable.set("1", "One");
        hashTable.set("2", "Two");
        hashTable.set("3", "Three");
        hashTable.set("1", "One 1");

        hashTable.get("1");
    }
}

class HashTable {
    HashMap<Integer, LinkedList<Node>> table;

    public HashTable() {
        this.table = new HashMap<>();
    }

    private Integer calculateHash(String key) {
        Integer hashCode = key.hashCode()*29;
        System.out.println("Calculated hash for key: " + key + " => " + hashCode);
        return hashCode;
    }

    public void set(String key, String value) {
        Integer hashCode = calculateHash(key);
        Node entry = new Node(key, value);
        if(!table.containsKey(hashCode)) {
            table.put(hashCode, new LinkedList<>());
            System.out.println(table);
            return;
        }
        var nodesAlreadyPresent = table.get(hashCode).stream().filter(node -> node.key.equals(key) && node.value.equals(value)).collect(Collectors.toList());
        nodesAlreadyPresent.forEach(node -> table.get(hashCode).remove(node));
        table.get(hashCode).add(new Node(key, value));
        System.out.println(table);
    }

    public String get(String key) {
        for(Node data: table.get(calculateHash(key))) {
            if(data.key.equals(key)) {
                System.out.println(table);
                return data.value;
            }
        }
        System.out.println(table);
        return null;
    }
}

class Node {
    String key;
    String value;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{ key='" + key + ", value='" + value + " }\n";
    }
}


