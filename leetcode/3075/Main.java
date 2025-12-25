import java.util.*;

class Solution {

    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;

        // Step 1: Sort the array
        Arrays.sort(happiness);

        // Step 2: Reverse to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = happiness[i];
            happiness[i] = happiness[n - 1 - i];
            happiness[n - 1 - i] = temp;
        }

        long ans = 0;

        // Step 3: Pick k children
        for (int i = 0; i < k; i++) {
            long value = (long) happiness[i] - i;
            if (value <= 0) break;
            ans += value;
        }

        return ans;
    }

    // -------- MAIN FUNCTION --------
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int[] happiness1 = {1, 2, 3};
        int k1 = 2;
        System.out.println(sol.maximumHappinessSum(happiness1, k1)); // Output: 4

        // Example 2
        int[] happiness2 = {1, 1, 1, 1};
        int k2 = 2;
        System.out.println(sol.maximumHappinessSum(happiness2, k2)); // Output: 1

        // Example 3
        int[] happiness3 = {2, 3, 4, 5};
        int k3 = 1;
        System.out.println(sol.maximumHappinessSum(happiness3, k3)); // Output: 5
    }
}
