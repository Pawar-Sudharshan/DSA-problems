class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int p1 = mid / m;
            int p2 = mid % m;

            if (matrix[p1][p2] == target) return true;

            if (matrix[p1][p2] > target) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}