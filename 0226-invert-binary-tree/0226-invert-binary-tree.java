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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode temp = root;
        f(temp);
        return root;
    }
    private static void f(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right != null){
            root.left = root.right;
            root.right = null;
        } 
        else if(root.left != null && root.right == null){
            root.right = root.left;
            root.left = null;
        } 
        else {
            TreeNode curr = root.left;
            root.left = root.right;
            root.right = curr;
        }
        f(root.left);
        f(root.right);

    }
}