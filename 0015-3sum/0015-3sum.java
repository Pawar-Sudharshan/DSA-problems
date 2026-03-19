import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // sort first

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i]; // we now want nums[j] + nums[k] == target
            Set<Integer> seen = new HashSet<>(); // acts like map.containsKey(remaining)
            for (int j = i + 1; j < n; j++) {
                int complement = target - nums[j];
                if (seen.contains(complement)) {
                    // we found nums[i] + complement + nums[j] == 0
                    List<Integer> triplet = Arrays.asList(nums[i], complement, nums[j]);
                    res.add(triplet);

                    // skip duplicates for nums[j]
                    while (j + 1 < n && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }
                seen.add(nums[j]);
            }
        }

        // remove possible duplicate triplets if any (defensive; usually sorting + skips enough)
        // But since array is sorted and we skip duplicates on i and j, this is typically not needed.

        return res;
    }
}
