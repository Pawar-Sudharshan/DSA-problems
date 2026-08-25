class Solution {
    public int jump(int[] nums) {
       int n = nums.length;
       int l = 0;
       int r = 0;
       int jumps = 0;
       while(r < n-1){
            int forthest = 0;
            for(int i = l ; i <= r ;i++){
                forthest = Math.max(forthest , i + nums[i]);
            }
             l = r+1;
             jumps += 1;
             r = forthest;
       }
       return jumps;
    }
}