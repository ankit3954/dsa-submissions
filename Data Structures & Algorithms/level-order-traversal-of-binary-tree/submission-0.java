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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            List<List<Integer>> res = new ArrayList<>();
            return res;
        }

        if(root.left == null && root.right == null){
            List<Integer> currList = new ArrayList<>();
            currList.add(root.val);
            List<List<Integer>> res = new ArrayList<>();
            res.add(currList);
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> currList = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode == null){
                q.add(null);
                res.add(currList);
                currList = new ArrayList<>();

                if( !q.isEmpty() && q.peek() == null){
                    break;
                }
                continue;
            }

            currList.add(currNode.val);

            if(currNode.left != null){
                q.add(currNode.left);
            }

            if(currNode.right != null){
                q.add(currNode.right);
            }
        }
        return res;
    }
}
