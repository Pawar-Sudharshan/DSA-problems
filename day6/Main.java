package day6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Testcase 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Testcase 1: " + Arrays.toString(solution.twoSum(nums1, target1))); // [0, 1]

        // Testcase 2
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        System.out.println("Testcase 2: " + Arrays.toString(solution.twoSum(nums2, target2))); // [1, 2]

        // Testcase 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        System.out.println("Testcase 3: " + Arrays.toString(solution.twoSum(nums3, target3))); // [0, 1]

        // Testcase 4 - No solution
        int[] nums4 = {1, 2, 3};
        int target4 = 7;
        System.out.println("Testcase 4: " + Arrays.toString(solution.twoSum(nums4, target4))); // [-1, -1]
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}

