class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;

        for (int x : nums) {
            left = Math.max(left, x);
            right += x;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canSplit(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canSplit(int[] nums, int k, int maxSum) {
        int subarrays = 1;
        int currentSum = 0;

        for (int x : nums) {
            if (currentSum + x > maxSum) {
                subarrays++;
                currentSum = x;

                if (subarrays > k) {
                    return false;
                }
            } else {
                currentSum += x;
            }
        }

        return true;
    }
}