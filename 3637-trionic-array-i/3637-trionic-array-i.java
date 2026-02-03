class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        
        // Try all possible pairs of indices (p, q)
        // where 0 < p < q < n - 1
        for (int p = 1; p < n - 1; p++) {
            for (int q = p + 1; q < n - 1; q++) {
                // Check if nums[0...p] is strictly increasing
                boolean inc1 = isIncreasing(nums, 0, p);
                
                // Check if nums[p...q] is strictly decreasing
                boolean dec = isDecreasing(nums, p, q);
                
                // Check if nums[q...n-1] is strictly increasing
                boolean inc2 = isIncreasing(nums, q, n - 1);
                
                if (inc1 && dec && inc2) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isIncreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] >= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isDecreasing(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}