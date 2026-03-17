class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        // Step 1: prefix sums vertically → histogram heights
        // matrix[i][j] becomes the height of consecutive 1s ending at row i in column j
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        // Step 2: for each row, sort histogram heights in descending order
        // This simulates optimal column rearrangement and uses histogram technique
        for (int i = 0; i < m; i++) {
            int[] heights = matrix[i].clone();
            java.util.Arrays.sort(heights); // ascending
            // reverse while using: heights[n - 1] ≥ heights[n - 2] ≥ ...

            for (int k = 0; k < n; k++) {
                int height = heights[n - 1 - k]; // kth largest height
                if (height == 0) break;          // further ones will also be 0
                int width = k + 1;               // we can take first (k + 1) columns
                ans = Math.max(ans, height * width);
            }
        }

        return ans;
    }
}
