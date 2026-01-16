import java.util.*;

class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        for (int[] row : mat) {
            List<Integer> list = new ArrayList<>(row.length);
            for (int x : row) {
                list.add(x);
            }

            int idx = Collections.binarySearch(list, target);
            if (idx >= 0) {  
                return true;
            }
        }
        return false;
    }
}
