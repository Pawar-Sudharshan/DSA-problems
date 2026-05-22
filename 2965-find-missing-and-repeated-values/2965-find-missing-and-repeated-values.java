class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[n*n +1];
        for(int[] a : grid){
            for(int x : a){
                cnt[x]++;
            }
        }
        int[] ans = new int[2];
        for(int i =0 ; i < cnt.length ;i++){
            if(cnt[i] == 2){
                ans[0] = i;
            }
            if(cnt[i] == 0) ans[1] = i;
        }
        return ans;

    }
}