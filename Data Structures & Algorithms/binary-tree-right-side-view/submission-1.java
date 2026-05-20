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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            List<Integer> res = new ArrayList<>();
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode currNode = q.poll();
            if(currNode == null){
                q.add(null);
                if( !q.isEmpty() && q.peek() == null){
                    break;
                }
                continue;
            }

            if(q.peek() == null){
                res.add(currNode.val);
            }


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
