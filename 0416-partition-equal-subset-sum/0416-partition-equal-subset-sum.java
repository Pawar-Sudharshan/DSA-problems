class Solution {
    static int sum;

    public boolean canPartition(int[] nums) {
        sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 != 0) return false;

        int k = sum / 2;
        int[][] dp = new int[nums.length][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return f(nums, 0, k, dp);
    }

    private static boolean f(int[] nums, int idx, int target, int[][] dp) {
        if (target == 0) return true;
        if (idx == nums.length || target < 0) return false;

        if (dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean take = f(nums, idx + 1, target - nums[idx], dp);
        boolean notTake = f(nums, idx + 1, target, dp);

        dp[idx][target] = (take || notTake) ? 1 : 0;
        return dp[idx][target] == 1;
    }
}