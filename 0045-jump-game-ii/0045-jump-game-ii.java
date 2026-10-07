class Solution {
    public int jump(int[] nums) {
       int l = 0 , r =0 , jump = 0;
       while(r < nums.length-1){
        int longest = 0;
        for(int i = l ; i <= r;i++){
            longest = Math.max(longest,i+nums[i]);
        }
        l = r+1;
        r  = longest;
        jump += 1;
       }
       return jump;
    }
}