class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return f(nums,0,dp)==1;
    }
    private static int f(int[] nums , int idx,int[] dp){
        if(idx >= nums.length-1) return 1;
        int curr = nums[idx];
        if(dp[idx] != -1) return dp[idx];
        for(int i =idx+curr ;i>idx;i--){
            if(i >= nums.length) return 1;
            if( f(nums,i,dp) ==1 ) return 1;
        }
        return dp[idx] = 0;
    }
}