class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0; i < n; i++) {
            int j = peak(mat[i]);
            boolean aboveOk = (i == 0) || (mat[i - 1][j] < mat[i][j]);
            boolean belowOk = (i == n - 1) || (mat[i + 1][j] < mat[i][j]);
            if (aboveOk && belowOk) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    
    private static int peak(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}