class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int[] prefixMin = new int[n];
        prefixMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], nums[i]);
        }

        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }
        for (int j = 1; j < n - 1; j++) {
            if (prefixMin[j - 1] < nums[j] && nums[j] < suffixMax[j + 1]) {
                return true;
            }
        }

        return false;
    }
}
