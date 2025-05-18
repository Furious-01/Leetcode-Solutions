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
    int total=0;
    public int findTilt(TreeNode root) {
        total=0;
        solve(root);
        return total;
    }
    public int solve(TreeNode root){
        if(root==null)return 0;
        int ls=solve(root.left);
        int rs=solve(root.right);
        total+=Math.abs(ls-rs);
        return ls+root.val+rs;
    }
}