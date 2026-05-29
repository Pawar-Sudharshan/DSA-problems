class Solution {
    static int getSum(int x){
        int sum =0 ;
        while(x >0){
            int rem = x %10;
            sum += rem;
            x = x/10;
        }
        return sum;
    }
    public int minElement(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int x : nums){
            ans =Math.min(ans,getSum(x));
        }
        return ans;
    }
}