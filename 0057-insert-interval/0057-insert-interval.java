class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        int n = intervals.length;

        if (n == 0) {
            return new int[][] { newInterval };
        }

        if (newInterval[1] < list.get(0)[0]) {
            list.add(0, newInterval);
            return list.toArray(new int[0][]);
        }

        if (newInterval[0] > list.get(n - 1)[1]) {
            list.add(newInterval);
            return list.toArray(new int[0][]);
        }

        list.add(newInterval);
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] curr = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int[] next = list.get(i);

            if (next[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                result.add(curr);
                curr = next;
            }
        }

        result.add(curr);

        return result.toArray(new int[0][]);
    }
}