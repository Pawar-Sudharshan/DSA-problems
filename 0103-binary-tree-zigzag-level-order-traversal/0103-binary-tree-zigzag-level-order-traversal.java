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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // TreeNode temp = root;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        boolean even = true;
        while(!q.isEmpty()){
          
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i = 0 ; i < size ;i++){
                TreeNode curr = q.poll();
                level.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            if(!even) Collections.reverse(level);
            ans.add(level);
            even = !even;

        }
        return ans;
    }
}