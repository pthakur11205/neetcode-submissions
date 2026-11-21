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
    private int res;
    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if(root==null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        res = Math.max(res, left+right+root.val);
        return root.val + Math.max(left, right);
    }
}
