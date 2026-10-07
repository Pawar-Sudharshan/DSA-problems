class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] i : dp) Arrays.fill(i,-1);
        return f(0,0,prices,dp);
    }
    private static int f(int buy , int idx, int[] prices,int[][] dp){
        if(idx >= prices.length ) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 0){
            return dp[idx][buy]= Math.max(-prices[idx]+f(1,idx+1,prices,dp),0+f(0,idx+1,prices,dp));
        }
        return dp[idx][buy]= Math.max(prices[idx]+f(0,idx+2,prices,dp),0+f(1,idx+1,prices,dp));
    }
}