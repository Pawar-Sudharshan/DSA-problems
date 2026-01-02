class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;
        int size = 10_000;
        int[] a= new int[size+1];
        int max = -1;
        int idx = -1;
        for(int x : nums){
            a[x]++;
            if(a[x] > max){
                max = a[x];
                idx = x;
            }
        }
        return idx;
    }
}