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

public class Codec {
    List<String> res = new ArrayList<>();
    int i = 0;
    public void serializeHelper(TreeNode root){
        if(root == null){
            res.add("N");
            return;
        } 

        res.add(Integer.toString(root.val));
        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeHelper(root);
        return String.join(",", res);
        // return res;
    }

    public TreeNode deserializeHelper(String[] array) {
           System.out.println(array[i]);
        if(array[i].equals("N")){
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(array[i]));
        i++;
        node.left = deserializeHelper(array);
        node.right = deserializeHelper(array);
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        System.out.println(data);
     
        TreeNode res = deserializeHelper(array);
        return res;
    }
}
