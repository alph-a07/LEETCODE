
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> list = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root==null)
            return ans;

        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int prevSize = list.size();
            for (int j = 0; j < prevSize; j++) {
                TreeNode tmp = list.remove();

                level.add(tmp.val);
                if (tmp.left != null) {
                    list.add(tmp.left);
                }
                if (tmp.right != null) {
                    list.add(tmp.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
