class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // prefixX[i][j] = number of 'X' in rectangle (0,0) to (i-1,j-1)
        // prefixY[i][j] = number of 'Y' in rectangle (0,0) to (i-1,j-1)
        int[][] prefixX = new int[n + 1][m + 1];
        int[][] prefixY = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixX[i][j] = prefixX[i - 1][j] + prefixX[i][j - 1] - prefixX[i - 1][j - 1];
                prefixY[i][j] = prefixY[i - 1][j] + prefixY[i][j - 1] - prefixY[i - 1][j - 1];

                char c = grid[i - 1][j - 1];
                if (c == 'X') {
                    prefixX[i][j]++;
                } else if (c == 'Y') {
                    prefixY[i][j]++;
                }
            }
        }

        int ans = 0;
        // we only consider submatrices (0,0) to (i,j)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int cntX = prefixX[i][j];
                int cntY = prefixY[i][j];

                if (cntX == cntY && cntX >= 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
