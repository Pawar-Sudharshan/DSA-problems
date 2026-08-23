class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b)-> a[1] - b[1]);
        int ans = 0;
        int[] last = intervals[0];
        int n = intervals.length;
        for(int i = 1; i < n ;i++){
            if(intervals[i][0] < last[1]){
                ans++;
            }else{
                last = intervals[i];
            }
        }
        return ans;
    }
}