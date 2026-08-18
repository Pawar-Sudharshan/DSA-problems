class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] frequency = new int[51];

        for (int value : nums) {
            frequency[value]++;
        }
        if (k == n) {
            int answer = -1;

            for (int value : nums) {
                answer = Math.max(answer, value);
            }

            return answer;
        }

        // For k == 1, each subarray contains one element.
        // A value is almost missing exactly when it occurs once in nums.
        if (k == 1) {
            for (int value = 50; value >= 0; value--) {
                if (frequency[value] == 1) {
                    return value;
                }
            }

            return -1;
        }

        // For 1 < k < n, only the first and last elements
        // can appear in exactly one subarray of size k.
        int answer = -1;

        if (frequency[nums[0]] == 1) {
            answer = Math.max(answer, nums[0]);
        }

        if (frequency[nums[n - 1]] == 1) {
            answer = Math.max(answer, nums[n - 1]);
        }

        return answer;
    }
}