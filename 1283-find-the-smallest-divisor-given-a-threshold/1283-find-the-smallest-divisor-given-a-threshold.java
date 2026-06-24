class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int left = 1, right = max;
        int ans = max;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = 0;

            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }

            if (sum <= threshold) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}