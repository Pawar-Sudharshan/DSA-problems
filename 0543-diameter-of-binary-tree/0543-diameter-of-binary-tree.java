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
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }
    
    // Returns the height of the tree rooted at node
    // Updates maxDiameter if the path through this node is larger
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Get heights of left and right subtrees
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        
        // The diameter through this node is sum of left and right heights
        int currentDiameter = leftHeight + rightHeight;
        
        // Update the maximum diameter found so far
        maxDiameter = Math.max(maxDiameter, currentDiameter);
        
        // Return the height of the tree rooted at this node
        // Height is 1 + max height of its subtrees
        return 1 + Math.max(leftHeight, rightHeight);
    }
}