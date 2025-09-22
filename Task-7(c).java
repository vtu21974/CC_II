import java.util.*;

// Define the TreeNode class
class TreeNode {
    int val;
    TreeNode left, right;

    // Constructor
    TreeNode(int key) {
        val = key;
        left = right = null;
    }
}

public class BinaryTree {
    
    public static TreeNode arrayToTree(int[] arr, int index, int n) {
        if (index >= n) {
            return null;
        }
        
        TreeNode root = new TreeNode(arr[index]);
        
        root.left = arrayToTree(arr, 2 * index + 1, n);  // Left child
        root.right = arrayToTree(arr, 2 * index + 2, n); // Right child
        
        return root;
    }
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};  
        int n = arr.length;
        TreeNode root = arrayToTree(arr, 0, n);
        
        List<Integer> result = levelOrderTraversal(root);
        
        System.out.println("Level Order Traversal: " + result);
    }
}
