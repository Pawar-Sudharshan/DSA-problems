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
    public int maxLevelSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        dfs(root,1,map);

        int level  = 1;
        int sum = map.get(1);
        for(int l : map.keySet()){
            int s = map.get(l);
            if(s > sum || s == sum && l < level){
                sum = s;
                level = l;
            }
        }
        return level;
    }

    public static void dfs(TreeNode root , int level , HashMap<Integer,Integer> map){
        if(root == null) return;
        map.put(level , map.getOrDefault(level , 0)+root.val);
        dfs(root.left , level+1,map);
        dfs(root.right,level+1 ,map);
    }
   
}