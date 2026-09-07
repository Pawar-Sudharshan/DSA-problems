class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        // int dp[] = new int[n+1]; 
        int p1 = nums[0];
        int p2 = Math.max(nums[0] , nums[1]);
        for(int i =2 ; i <n ;i++){
           int next = Math.max(nums[i]+p1 ,p2);
           p1 = p2;
           p2 = next;
        }
        return p2;
    }
    private static  int f(int idx,int[] nums , int[] dp){
        if(idx >= nums.length) return 0;
        if(dp[idx] != -1) return dp[idx];
        return dp[idx];
    }
}