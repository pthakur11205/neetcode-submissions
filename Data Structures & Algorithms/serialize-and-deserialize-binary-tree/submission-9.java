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

    // [1, 2, N, N, 3, 4, N, N, 5, N, N]

    //      [1]
    //. [2]       [3]
    //          [4]  [5]
    
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
        String[] vals = data.split(",");
        i=0;
        return dfsD(vals);
    }

    private TreeNode dfsD(String[] vals) {
        if(vals[i].equals("N")) {
            i++;
            return null;
        }
        int rootVal = Integer.parseInt(vals[i++]);
        TreeNode root = new TreeNode(rootVal);
        root.left = dfsD(vals);
        root.right = dfsD(vals);
        return root;
    }

    
}
