class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robbery(nums , 0 , nums.length , dp);
    }
    public static int robbery(int[] nums , int idx , int n , int dp[]){
        if( idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = robbery(nums,idx+2,n , dp);
        int non = robbery(nums,idx+1,n , dp);
        return dp[idx] =  Math.max(take+nums[idx],non);
    }
}