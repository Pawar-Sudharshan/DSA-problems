class Solution {
    static final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int k = n * m;

        int[] arr = new int[k];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j] % MOD;
            }
        }

        int[] pref = new int[k];
        int[] suff = new int[k];

        pref[0] = 1;
        for (int i = 1; i < k; i++) {
            pref[i] = (int)((pref[i - 1] * 1L * arr[i - 1]) % MOD);
        }

        suff[k - 1] = 1;
        for (int i = k - 2; i >= 0; i--) {
            suff[i] = (int)((suff[i + 1] * 1L * arr[i + 1]) % MOD);
        }

        int[][] ans = new int[n][m];
        idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int)((pref[idx] * 1L * suff[idx]) % MOD);
                idx++;
            }
        }

        return ans;
    }
}
