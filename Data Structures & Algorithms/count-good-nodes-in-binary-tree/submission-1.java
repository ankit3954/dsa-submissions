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
    int maxRoot = Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
       return goodNodesHelper(root, Integer.MIN_VALUE);
    }

    public int goodNodesHelper(TreeNode root, int maxValue) {
        if(root == null) return 0;

        // if(root.left == null && root.right == null) return 1;

        if(root.val >= maxValue){
            maxValue = root.val;
            int leftNodes =  goodNodesHelper(root.left, maxValue);
            int rightNodes = goodNodesHelper(root.right, maxValue);
            return 1 + leftNodes + rightNodes;
        }else{
            int leftNodes =  goodNodesHelper(root.left, maxValue);
            int rightNodes = goodNodesHelper(root.right, maxValue);
            return leftNodes + rightNodes;
        }
    }
}
