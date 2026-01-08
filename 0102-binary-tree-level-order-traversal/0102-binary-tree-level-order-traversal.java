/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Recursive DFS to build map with levels
        traverse(root, 0, map);
        
        // Convert map to result list
        for (int i = 0; i < map.size(); i++) {
            result.add(map.get(i));
        }
        
        return result;
    }
    
    private void traverse(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        if (node == null) return;
        
        // Add current node value to the appropriate level
        map.putIfAbsent(level, new ArrayList<>());
        map.get(level).add(node.val);
        
        // Recursively traverse left and right with incremented level
        traverse(node.left, level + 1, map);
        traverse(node.right, level + 1, map);
    }
}