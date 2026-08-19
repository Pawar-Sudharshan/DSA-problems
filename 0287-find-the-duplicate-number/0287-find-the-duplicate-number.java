class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n+1];
        for(int x : nums){
            cnt[x]++;
            if(cnt[x] == 2) return x;
        }
        return -1;
    }
}