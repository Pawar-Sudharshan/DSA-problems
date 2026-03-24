class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;      
        int l = 0;
        int ans = 1;

        for (int r = 0; r < n; r++) {
            sum += nums[r];
            long cost = (long) nums[r] * (r - l + 1) - sum;

            while (cost > k) {
                sum -= nums[l];
                l++;
                cost = (long) nums[r] * (r - l + 1) - sum;
            }

            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
