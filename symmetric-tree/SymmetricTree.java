import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
 
public class SymmetricTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
 
        Vector<Integer> left = new Vector<>();
        Vector<Integer> right = new Vector<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left != null) {
            queue.add(root.left);
            while (!queue.isEmpty()) {
                TreeNode current = queue.remove();
                if (current != null) {
                    left.add(current.val);
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    left.add(-1);
                }
            }
        }
 
        queue.clear();
        if (root.right != null) {
            queue.add(root.right);
            while (!queue.isEmpty()) {
                TreeNode current = queue.remove();
                if (current != null) {
                    right.add(current.val);
                    queue.add(current.right);
                    queue.add(current.left);
                } else {
                    right.add(-1);
                }
            }
        }
 
        if (left.size() != right.size()) {
            return false;
        }
        for (int i = 0; i < left.size(); i++) {
            if (left.get(i) != right.get(i)) {
                return false;
            }
        }
        return true;
    }
}
