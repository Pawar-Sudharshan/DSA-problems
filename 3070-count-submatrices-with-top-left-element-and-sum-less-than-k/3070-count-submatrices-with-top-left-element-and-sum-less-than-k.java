class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        // ans should be m x n, same as grid
        int[][] ans = new int[m][n];

        // prefix sum for (0,0)
        ans[0][0] = grid[0][0];

        // first row
        for (int j = 1; j < n; j++) {
            ans[0][j] = ans[0][j - 1] + grid[0][j];
        }

        // first column
        for (int i = 1; i < m; i++) {
            ans[i][0] = ans[i - 1][0] + grid[i][0];
        }

        // rest of the cells
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1] - ans[i - 1][j - 1] + grid[i][j];
            }
        }

        // count submatrices (0,0) to (i,j) with sum <= k
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] <= k) count++;
            }
        }

        return count;
    }
}
