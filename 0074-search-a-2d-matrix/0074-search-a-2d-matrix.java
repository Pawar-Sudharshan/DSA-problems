import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;        // number of rows
        int m = mat[0].length;     // number of columns

        int left = 0;
        int right = n * m - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int row = mid / m;     // use m here
            int col = mid % m;     // and here

            if (mat[row][col] == target) {
                return true;
            } else if (mat[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
