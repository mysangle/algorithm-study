import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode r = queue.poll();
      TreeNode temp = r.right;
      r.right = r.left;
      r.left = temp;
      if (r.right != null) {
        queue.add(r.right);
      }
      if (r.left != null) {
        queue.add(r.left);
      }
    }
    return root;
  }
}

