class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int n = nums.length;
       long sum = 0;
      
       for(int i = 0  ; i < k ;i++){
        sum += nums[i];
       } 
       double ans =(double) sum / k;
       for(int i = k ; i < n ;i++){
        sum += nums[i];
        sum -= nums[i-k];
        ans =Math.max(ans ,(double)sum/k);
       }
       return ans;
    }
}