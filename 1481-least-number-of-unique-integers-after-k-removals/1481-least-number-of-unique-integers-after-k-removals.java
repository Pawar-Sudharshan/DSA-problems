class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // 1) count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        // 2) min-heap of frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int f : freq.values()) {
            pq.offer(f);
        }

        // 3) remove numbers with smallest freq first
        int unique = pq.size();
        while (k > 0 && !pq.isEmpty()) {
            int f = pq.poll();
            if (k >= f) {
                k -= f;
                unique--;          // this number fully removed
            } else {
                break;             // cannot fully remove the next one
            }
        }
        return unique;
    }
}
