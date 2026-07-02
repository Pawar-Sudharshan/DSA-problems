class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        freq.put(0, 1);
        for (int num : nums) {
            sum += num;
            int need = sum - goal;
            if (freq.containsKey(need)) {
                count += freq.get(need);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}