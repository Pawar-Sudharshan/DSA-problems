class Solution {
    public int maxSubArray(int[] nums) {
    //    int maxSoFar = nums[0];
    //    int max = nums[0];
    //    for(int i = 1; i < nums.length;i++){
    //         maxSoFar = Math.max(nums[i],maxSoFar+nums[i]);
    //         max =Math.max(max,maxSoFar);
    //    }
    //    return max;
    int n = nums.length;
    int[] dp = new int[n];
    int ans = nums[0];
    dp[0] = nums[0];
    for(int i = 1;i<n;i++){
        dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        ans = Math.max(ans,dp[i]);
    }
    return ans;

    }
}