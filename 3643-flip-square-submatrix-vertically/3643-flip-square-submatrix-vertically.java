class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            int r1 = x + i;
            int r2 = x + k - 1 - i;
            for (int c = y; c < y + k; c++) {
                int tmp = grid[r1][c];
                grid[r1][c] = grid[r2][c];
                grid[r2][c] = tmp;
            }
        }
        return grid;
    }
}
