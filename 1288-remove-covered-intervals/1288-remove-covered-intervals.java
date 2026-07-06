import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1]; // important
        });

        int removable = 0;
        int maxEnd = -1;

        for (int[] interval : intervals) {
            if (interval[1] <= maxEnd) {
                // covered
                removable++;
            } else {
                maxEnd = interval[1];
            }
        }

        return intervals.length - removable;
    }
}