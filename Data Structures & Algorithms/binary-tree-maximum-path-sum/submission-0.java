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
    int maxPathSum = Integer.MIN_VALUE;

     public int maxPathSumHelper(TreeNode root) {
        if(root == null) return 0;

        int leftGain = Math.max(maxPathSumHelper(root.left), 0);
        int rightGain = Math.max(maxPathSumHelper(root.right), 0);

        int currentMaxPath = root.val + leftGain + rightGain;

        maxPathSum = Math.max(maxPathSum, currentMaxPath);

        return root.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return maxPathSum;
    }
}
