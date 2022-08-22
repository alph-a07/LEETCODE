import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// left root right
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();

        if (root == null) return ans;

        TreeNode curr = root;

        while (curr != null) {
            // left is null
            if (curr.left == null) {
                ans.add(curr.val); // add root
                curr = curr.right; // move right
            }
            // left exists
            else {
                TreeNode pre = curr.left;
                // rightmost element of the left subtree
                while (pre.right != null && pre.right != curr) pre = pre.right;

                // temporarry link to backtrack
                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left; // move left
                }
                // restoring tree
                else {
                    pre.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
