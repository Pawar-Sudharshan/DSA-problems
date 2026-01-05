class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private boolean helper(int[] nums, int l, int r, int target) {
        if (l > r) return false;

        int mid = l + (r - l) / 2;

        if (nums[mid] == target) return true;

        // Handle duplicates on both ends
        if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
            // shrink both sides
            return helper(nums, l + 1, r - 1, target);
        }

        // Left part sorted
        if (nums[l] <= nums[mid]) {
            if (nums[l] <= target && target < nums[mid]) {
                return helper(nums, l, mid - 1, target);
            } else {
                return helper(nums, mid + 1, r, target);
            }
        } else { // Right part sorted
            if (nums[mid] < target && target <= nums[r]) {
                return helper(nums, mid + 1, r, target);
            } else {
                return helper(nums, l, mid - 1, target);
            }
        }
    }
}
