class Solution {
    public int maximumDifference(int[] nums) {
        int ans = -1;
        int min = nums[0];
        int n = nums.length;
        for(int i = 1 ; i < n ;i++){
            if (nums[i] > min)
                ans =Math.max(ans , Math.abs(min-nums[i]));
            min = Math.min(nums[i],min);
        }
        return ans;
    }
}