class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int a[] : dp ) Arrays.fill(a,-1);
        return f(text1, text2, 0, 0,dp);
    }

    private int f(String a, String b, int i, int j,int[][] dp) {
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];
        if (a.charAt(i) == b.charAt(j)) {
            return dp[i][j] =  1 + f(a, b, i + 1, j + 1,dp);
        }

        return dp[i][j] =  Math.max(
            f(a, b, i + 1, j,dp),
            f(a, b, i, j + 1 ,dp)
        );
    }
}