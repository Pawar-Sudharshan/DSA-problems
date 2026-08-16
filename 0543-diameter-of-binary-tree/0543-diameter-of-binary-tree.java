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
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        int max = Integer.MIN_VALUE;
        for (int val : list) {
            if (val > max) max = val;
        }
        // Collections.sort(list);
        return max;
        // return list.get(list.size()-1) - list.get(0);
    }

    private int helper(TreeNode root, List<Integer> list) {
        if (root == null) return 0;

        int leftHeight = helper(root.left, list);
        int rightHeight = helper(root.right, list);

        list.add(leftHeight + rightHeight);
        // list.add(x);
        // helper(root.left,list,x-1);
        // helper(root.right ,list,x+1);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // Returns the height of the tree rooted at node
    // Updates maxDiameter if the path through this node is larger
   
}