class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int x : nums) sum += x;
        if (sum % 2 == 1) return false;

        sum = sum / 2;
        int[][] dp = new int[sum + 1][n + 1];
        for (int[] a : dp) Arrays.fill(a, -1);

        return f(nums, sum, n - 1, dp) == 1;
    }

    private int f(int[] nums, int sum, int i, int[][] dp) {
        if (sum < 0) return 0;
        if (sum == 0) return 1;

        if (i == 0) {
            return (sum == nums[0]) ? 1 : 0;
        }

        if (dp[sum][i] != -1) return dp[sum][i];

        int left = f(nums, sum - nums[i], i - 1, dp);
        int right = f(nums, sum, i - 1, dp);

        return dp[sum][i] = (left == 1 || right == 1) ? 1 : 0;
    }
}