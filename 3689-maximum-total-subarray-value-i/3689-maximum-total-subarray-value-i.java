class Solution {
    public long maxTotalValue(int[] nums, int k) {
       int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
       for(int x : nums){
        min = Math.min(min,x);
        max = Math.max(max,x);
       }
       return (long)(max-min)*k;
    }
}