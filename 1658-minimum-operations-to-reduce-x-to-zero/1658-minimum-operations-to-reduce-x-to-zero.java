class Solution {
    public int minOperations(int[] nums, int x) {
        long sum = 0;
        int n = nums.length;
        for (int v : nums) sum += v;

        if (sum == x) return n;
        if (sum < x) return -1;
        long target = sum - x;
        long curr = 0;
        int left = 0;
        int maxLen = -1;
        for (int right = 0; right < n; right++) {
            curr += nums[right];
            while (curr > target && left <= right) {
                curr -= nums[left++];
            }
            if (curr == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}
