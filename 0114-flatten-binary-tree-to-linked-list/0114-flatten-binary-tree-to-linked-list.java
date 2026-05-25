class Solution {
    public void flatten(TreeNode root) {
        helper(root);
    }
    private TreeNode helper(TreeNode node) {
        if (node == null) return null;
        TreeNode leftTail = helper(node.left);
        TreeNode rightTail = helper(node.right);
        if (leftTail != null) {
            leftTail.right = node.right;  
            node.right = node.left;        
            node.left = null;           
        }

        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return node;
    }
}