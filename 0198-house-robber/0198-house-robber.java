class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n == 0) return 0;
        if(n ==1 ) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2 ; i < n ;i++){
            int take = nums[i] + dp[i-2];
            dp[i] = Math.max(dp[i-1],take);
        }
        return dp[n-1];
    }
    public static int robbery(int[] nums , int idx , int n , int dp[]){
        // int[] dp = new int[nums.length+1];
        // Arrays.fill(dp,-1);
        // return robbery(nums , 0 , nums.length , dp);
        if( idx >= n) return 0;
        if(dp[idx] != -1) return dp[idx];
        int take = robbery(nums,idx+2,n , dp);
        int non = robbery(nums,idx+1,n , dp);
        return dp[idx] =  Math.max(take+nums[idx],non);
    }
}