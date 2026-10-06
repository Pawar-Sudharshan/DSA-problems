class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(nums, -1, 0, dp);
    }

    private static int f(int[] nums, int prev, int idx, int[][] dp) {

        if (idx == nums.length)
            return 0;
        if (dp[idx][prev + 1] != -1)
            return dp[idx][prev + 1];

        int not = f(nums, prev, idx + 1, dp);
        int take = 0;

        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + f(nums, idx, idx + 1, dp);
        }

        return dp[idx][prev + 1] = Math.max(take, not);
    }
}