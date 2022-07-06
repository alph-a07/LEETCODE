
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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode pointer = root;

        while (!stack.isEmpty() || pointer != null) {
            if (pointer != null) {
                stack.push(pointer);
                ans.add(pointer.val);
                pointer = pointer.left;
            } else {
                TreeNode temp = stack.pop();
                pointer = temp.right;
            }
        }
        return ans;
    }
}
