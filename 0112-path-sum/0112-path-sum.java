class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return f(root, targetSum, 0);
    }

    private static boolean f(TreeNode root, int k, int sum) {
        if (root == null) return false;

        sum += root.val;

        if (root.left == null && root.right == null) {
            return sum == k;
        }

        return f(root.left, k, sum) || f(root.right, k, sum);
    }
}