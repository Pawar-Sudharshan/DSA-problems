class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int num = e.getKey();
            int freq = e.getValue();
            freqMap.computeIfAbsent(freq, x -> new ArrayList<>()).add(num);
        }

      
        int[] res = new int[k];
        int idx = 0;
        for (int freq : freqMap.descendingKeySet()) {
            for (int num : freqMap.get(freq)) {
                res[idx++] = num;
                if (idx == k) return res;
            }
        }
        return res; 
    }
}
