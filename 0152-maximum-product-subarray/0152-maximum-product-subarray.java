class Solution {
    public int maxProduct(int[] nums) {
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            if (x < 0) {
                int tmp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = tmp;
            }

            maxSoFar = Math.max(x, maxSoFar * x);
            minSoFar = Math.min(x, minSoFar * x);

            ans = Math.max(ans, maxSoFar);
        }

        return ans;
    }
}
