class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode node, int targetSum, int currentSum, List<Integer> path) {
        if (node == null) return;

        currentSum += node.val;
        path.add(node.val);

        // Leaf node
        if (node.left == null && node.right == null) {
            if (currentSum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, targetSum, currentSum, path);
            dfs(node.right, targetSum, currentSum, path);
        }

        path.remove(path.size() - 1); // backtrack
    }
}
