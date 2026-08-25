class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int i = 1 ; i <= 100;i++){
            if(!set.contains(i*k)) return i*k;
        }
        return 101;
    }
}