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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int dept1 = depth(root.left) , dept2 = depth(root.right);
        if(dept1 == dept2) return root;
        if(dept1 > dept2) return subtreeWithAllDeepest(root.left);
        return subtreeWithAllDeepest(root.right);
        
    }
    public static int depth(TreeNode root){
        if(root != null){
            return 1+ Math.max(depth(root.left ), depth(root.right));
        }
        return 0;
    }
}