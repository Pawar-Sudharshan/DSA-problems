class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i = 1 ; i <= amount ;i++ ){
            for(int cost : coins){
                if(i - cost >= 0){
                    dp[i] = Math.min(dp[i],1+dp[i-cost]);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}