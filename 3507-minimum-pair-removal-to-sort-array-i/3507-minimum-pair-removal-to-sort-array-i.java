class Solution {
    public int minimumPairRemoval(int[] nums) {
        // Convert array to ArrayList for easier manipulation
        List<Long> list = new ArrayList<>();
        for (int num : nums) {
            list.add((long) num);
        }
        
        int operations = 0;
        
        // Keep performing operations until array is non-decreasing
        while (!isNonDecreasing(list)) {
            // Find the minimum sum adjacent pair (leftmost if tie)
            int minIndex = 0;
            long minSum = list.get(0) + list.get(1);
            
            for (int i = 1; i < list.size() - 1; i++) {
                long currentSum = list.get(i) + list.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    minIndex = i;
                }
            }
            
            // Replace the pair with their sum
            long sum = list.get(minIndex) + list.get(minIndex + 1);
            list.remove(minIndex + 1);
            list.set(minIndex, sum);
            operations++;
        }
        
        return operations;
    }
    
    private boolean isNonDecreasing(List<Long> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}