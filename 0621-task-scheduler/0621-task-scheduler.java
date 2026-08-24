class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];

        for (char ch : tasks) {
            cnt[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : cnt) {
            if (i != 0) {
                pq.offer(i);
            }
        }

        int time = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        while (!pq.isEmpty() || !map.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int top = pq.poll();
                top--;

                if (top > 0) {
                    map.computeIfAbsent(time + n, key -> new ArrayList<>()).add(top);
                }
            }

            if (map.containsKey(time)) {
                for (int value : map.get(time)) {
                    pq.offer(value);
                }

                map.remove(time);
            }
        }

        return time;
    }
}