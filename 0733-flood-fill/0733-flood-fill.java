class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        f(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private static void f(int[][] image, int r, int c, int color, int prev) {
        int n = image.length;
        int m = image[0].length;

        image[r][c] = color;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] d : directions) {
            int i = r + d[0];
            int j = c + d[1];

            if (i >= 0 && i < n && j >= 0 && j < m && image[i][j] == prev) {
                f(image, i, j, color, prev);
            }
        }
    }
}