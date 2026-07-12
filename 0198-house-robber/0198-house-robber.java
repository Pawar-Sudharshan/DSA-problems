class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        for(int i = 1; i < n ;i++){
            int take = nums[i] +( (i>1)?dp[i-2]:0);
            int non = dp[i-1];
            dp[i]=Math.max(take,non);
        }
        return  dp[n-1];
    }
    private static int helper(int[] nums , int idx,int[] dp){
        if(idx == 0) return nums[idx];
        // if(idx < 0) return 0;
        
        int pick = nums[idx];
        if(idx-2 >= 0 && dp[idx-2] == -1  ){
            dp[idx-2] = helper(nums,idx-2,dp);
        }
        pick +=(idx-2 >= 0)?dp[idx-2]:0;

        int nonPick = 0;
        if(idx-1 >= 0 && dp[idx-1] == -1  ){
            dp[idx-1] = helper(nums,idx-1,dp);
        } 
        nonPick = (idx-1 >= 0)?dp[idx-1]:0;
        return Math.max(pick , nonPick);
    }
}