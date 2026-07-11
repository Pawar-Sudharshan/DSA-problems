class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        // int[] dp = new int[n + 1];
        int p1  = 1;
        // dp[2] = 2;
        int p2 = 2;
        for (int i = 3; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int temp = p2;
            p2 = p2+p1;
            p1 = temp;
        }
        return p2;
    }
}