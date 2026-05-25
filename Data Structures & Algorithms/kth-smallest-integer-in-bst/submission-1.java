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
    public int noOfNodes(TreeNode root){
        if(root == null) return 0;

        int leftNodes = noOfNodes(root.left);
        int rightNodes = noOfNodes(root.right);

        return 1 + leftNodes + rightNodes;

    }
    public int kthSmallest(TreeNode root, int k) {
        if(k == 1 && (root.left == null && root.right == null)) return root.val;

        int noOfNodesinLeftTree = noOfNodes(root.left);
        int newK = k - (noOfNodesinLeftTree + 1); // 1 is for root

        if(newK < 0){
            return kthSmallest(root.left, k);
        }else if(newK > 0){
            return kthSmallest(root.right, newK);
        }else{
            return root.val;
        }
    }
}
