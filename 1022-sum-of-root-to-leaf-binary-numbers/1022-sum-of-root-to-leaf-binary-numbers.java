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
    static int ans ;
    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        helper(root,0);
        return ans;
    }
    static void helper(TreeNode  root,int sum  ){
        if(root == null) return ;
        
        sum= ((sum <<1) | root.val);
        if(root.left == null && root.right == null){
            ans += sum;
            return;
        }
        
        helper(root.left , sum);
        helper(root.right,sum);
    }
}