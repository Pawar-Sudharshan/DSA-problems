class Solution {
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int p1 = 0;          
        for (int p2 = 0; p2 < n; p2++) {
            if (nums[p2] != 0) {
                swap(nums, p1, p2);
                p1++;
            }
        }
    }
}
