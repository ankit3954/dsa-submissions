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
     private static class Pair {
        int diameter;
        int height;

        Pair(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        Pair res = findDiameter(root);
        return res.diameter;
    }

    public static Pair findDiameter(TreeNode root){
        if(root == null){
            Pair p = new Pair(0, 0);
            return p;
        }

        Pair leftAns = findDiameter(root.left);
        Pair rightAns = findDiameter(root.right);

        int height = 1 + Math.max(leftAns.height, rightAns.height);
        int diameter = Math.max(leftAns.height + rightAns.height, Math.max(leftAns.diameter, rightAns.diameter));

        Pair ans = new Pair(diameter, height);

        return ans;
    }
}
