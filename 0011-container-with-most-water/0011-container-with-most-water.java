class Solution {
    public int maxArea(int[] nums) {
        int left = 0 ;
        int right = nums.length-1;
        int ans =0;
        while(left < right){
            int width = right - left ;
            int curr = Math.min(nums[left],nums[right]) * width;
            ans = Math.max(ans,curr);
            if(nums[left] < nums[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}