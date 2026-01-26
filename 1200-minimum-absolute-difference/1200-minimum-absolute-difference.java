import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr); // step 1

        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;

        // step 2: find global minimum difference between adjacent elements
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1]; // arr is sorted, so diff >= 0
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        // step 3: collect all pairs with difference == minDiff
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
