class Solution {
    public int climbStairs(int n) {
    //   int dp[] = new int[n+1];
    //   Arrays.fill(dp,-1);
    //   f(n,dp);
    int prev1 = 1;
    int prev2 = 1;
    // dp[2] = 2;
    for(int i = 2 ; i <= n ;i++){
       int temp = prev1+prev2;
        prev1 = prev2;
        prev2 = temp;
    }
      
      return prev2;
    }

    private int f(int n , int[] dp){
        if(n == 1 || n == 2) return dp[n] =  n;
        if(dp[n] != -1) return dp[n];
       return dp[n] = f(n-1,dp) + f(n-2,dp);
    }
}