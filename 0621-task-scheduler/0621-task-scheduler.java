class Solution {
    public int leastInterval(char[] tasks, int n) {
        // int[] cnt = new int[26];
        // int max = 0;
        // for (char ch : tasks) {
        //     cnt[ch - 'A']++;
        //     max = Math.max(max,cnt[ch-'A']);
        // }
        // int cntMax = 0;
        // for(int i : tasks) if(i == max) cntMax++;
        // int time = (max-1)*(n+1) + cntMax;
        // return Math.max(time,tasks.length);
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // for (int i : cnt) {
        //     if (i != 0) {
        //         pq.offer(i);
        //     }
        // }

        // int time = 0;
        // Map<Integer, List<Integer>> map = new HashMap<>();

        // while (!pq.isEmpty() || !map.isEmpty()) {
        //     time++;

        //     if (!pq.isEmpty()) {
        //         int top = pq.poll();
        //         top--;

        //         if (top > 0) {
        //             map.computeIfAbsent(time + n, key -> new ArrayList<>()).add(top);
        //         }
        //     }

        //     if (map.containsKey(time)) {
        //         for (int value : map.get(time)) {
        //             pq.offer(value);
        //         }

        //         map.remove(time);
        //     }
        // }

        // return time;
        // int max = 0;
         int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find maximum frequency
        int maxFreq = 0;

        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Step 3: Count how many tasks have maximum frequency
        int countMaxFreq = 0;

        for (int f : freq) {
            if (f == maxFreq) {
                countMaxFreq++;
            }
        }

        // Step 4: Calculate minimum intervals
        int result = (maxFreq - 1) * (n + 1) + countMaxFreq;

        // We cannot need fewer intervals than the number of tasks
        return Math.max(tasks.length, result);
    }
}