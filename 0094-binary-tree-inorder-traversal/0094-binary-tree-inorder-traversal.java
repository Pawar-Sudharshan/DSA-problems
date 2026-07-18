class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
       helper(root , ans);
        // if(root == null) return ans;
        // Stack<TreeNode> stack = new Stack<>();
        // stack.push(root);
        // while(!stack.isEmpty()){
        //     TreeNode curr = stack.pop();
        //     ans.add(curr.val);
        //     if(curr.right != null) stack.push(curr.right);
        //     if( curr.left != null) stack.push(curr.left);
        // }
       return ans;
    }
    private static void helper(TreeNode root , List<Integer> ans){
        if(root == null) return;
       
        helper(root.left , ans);
        ans.add(root.val);
        helper(root.right , ans);
    }
}
