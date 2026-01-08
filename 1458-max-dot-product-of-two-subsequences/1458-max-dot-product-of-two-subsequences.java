class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        
        // dp[i][j] = max dot product using nums1[0..i] and nums2[0..j]
        long[][] dp = new long[n][m];
        
        // Initialize with very small value (no subsequence selected yet)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Long.MIN_VALUE;
            }
        }
        
        // Fill DP table
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long prod = (long) nums1[i] * nums2[j];
                
                // Option 1: Start new subsequence at (i, j)
                dp[i][j] = prod;
                
                // Option 2: Extend previous subsequence
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + prod);
                }
                
                // Option 3: Skip nums1[i]
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                }
                
                // Option 4: Skip nums2[j]
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }
        
        return (int)dp[n-1][m-1];
    }
}