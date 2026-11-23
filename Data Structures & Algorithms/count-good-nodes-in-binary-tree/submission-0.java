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
    int counter = 0;
    public int goodNodes(TreeNode root) {
        dfsHelper(root, root.val);
        return counter;
    }

    private void dfsHelper(TreeNode node, int highestVal) {
        if (node != null) {
            if (node.val >= highestVal) {
                counter++;
                highestVal = node.val;
            }
            dfsHelper(node.left, highestVal);
            dfsHelper(node.right, highestVal);
        }
    }
}
