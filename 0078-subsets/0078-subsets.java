import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            result.add(list);
        }

        return result;
    }
}