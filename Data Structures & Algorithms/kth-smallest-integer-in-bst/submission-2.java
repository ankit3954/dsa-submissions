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
    int count = 0;
    int res = 0;
    public void inOrder(TreeNode root, int k){
        if(root == null) return;

        inOrder(root.left, k);
        count++;
        if(count == k){
            res = root.val;
        }
        inOrder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        //basically it is inorder traversal
        inOrder(root, k);
        return res;
    }
}
