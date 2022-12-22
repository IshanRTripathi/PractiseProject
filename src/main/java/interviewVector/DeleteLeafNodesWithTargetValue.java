package interviewVector;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(Integer val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class DeleteLeafNodesWithTargetValue {
    public static void main(String[] args) {
        DeleteLeafNodesWithTargetValue obj = new DeleteLeafNodesWithTargetValue();
        obj.removeLeafNodes(constructTreeNode(new Integer[]{1,2,3,2,null,2,4}), 3);
    }

    private static TreeNode constructTreeNode(Integer[] integers) {
        TreeNode root = null;
        Queue<TreeNode> q = new LinkedList<>();
        for(Integer x: integers) {
            TreeNode temp = new TreeNode(x);
            if (root == null)
                root = temp;
            else {
                assert q.peek() != null;
                if(q.peek().left == null){
                    q.peek().left = temp;
                } else {
                    q.peek().right = x == null ? null : temp;
                    q.remove();
                }
            }
            q.add(temp);
        }
        return root;
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null || root.val == target) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            System.out.println("Removed node: " + temp.val);
            if(temp.left != null && isLeafNode(temp.left) && temp.left.val == target ) {
                System.out.println("\tCurrent node left is target: " + temp.left.val);
                temp.left = null;
            }
            if(temp.right != null && isLeafNode(temp.right) && temp.right.val == target ) {
                System.out.println("\tCurrent node right is target: " + temp.right.val);
                temp.right = null;
            }
            if(temp.left != null) {
                System.out.println("Add to queue: " + temp.left.val);
                queue.add(temp.left);
            }
            if(temp.right != null) {
                System.out.println("Add to queue: " + temp.right.val);
                queue.add(temp.right);
            }
        }
        return root;
    }
    boolean isLeafNode(TreeNode root) {
        if(root != null && (root.left == null && root.right == null)){
            System.out.println("\tNode is leaf node: " + root.val);
            return true;
        }
        return false;
    }
}
