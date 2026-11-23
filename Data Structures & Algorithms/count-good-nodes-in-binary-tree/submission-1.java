/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfsHelper(root, root.val);
    }

    private int dfsHelper(TreeNode node, int highestVal) {
        if (node == null) {
            return 0;
        }
        highestVal = Math.max(highestVal, node.val);
        int res = node.val >= highestVal ? 1 : 0;
        res += dfsHelper(node.left, highestVal);
        res += dfsHelper(node.right, highestVal);
        return res;
    }
}
