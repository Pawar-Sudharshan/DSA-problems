class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[n];
        int id = 0;
        comp[0] = id;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                id++;
            }
            comp[i] = id;
        }

        int q = queries.length;
        boolean[] ans = new boolean[q];

        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = (comp[u] == comp[v]);
        }

        return ans;
    }
}