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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsS(root, res);
        return String.join(",", res);
    }

    private void dfsS(TreeNode root, List<String> res) {
        if(root==null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsS(root.left, res);
        dfsS(root.right, res);
    }


    private int i;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        i=0;
        String[] vals = data.split(",");
        return dfsD(vals);
    }

    private TreeNode dfsD(String[] vals) {
        if(vals[i].equals("N")) {
            i++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(vals[i]));
        i++;
        root.left = dfsD(vals);
        root.right = dfsD(vals);
        return root;
    }
}
