import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        curr.add(intervals[0][0]);
        curr.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if (curr.get(1) >= intervals[i][0]) {
                curr.set(1, Math.max(curr.get(1), intervals[i][1]));
            } else {
                ans.add(curr);
                curr = new ArrayList<>();
                curr.add(intervals[i][0]);
                curr.add(intervals[i][1]);
            }
        }

        ans.add(curr);

        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }

        return res;
    }
}