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
     public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null && q != null) || (p != null && q == null)) return false;

        boolean leftTree = isSameTree(p.left, q.left);
        boolean rightTree = isSameTree(p.right, q.right);

        if(p.val != q.val) return false;

        return leftTree && rightTree;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(subRoot == null){
            return true;
        }

        if(root == null){
            return false;
        }

        boolean isBothSameTree = isSameTree(root, subRoot);
        if(!isBothSameTree){
            boolean left = isSubtree(root.left, subRoot);
            boolean right = isSubtree(root.right, subRoot);
            return left || right;
        }

        return isBothSameTree;
    
    }
}
