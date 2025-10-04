# Two Sum

Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to target.

- You may assume that each input would have **exactly one solution**, and you may not use the **same element twice**.
- You can return the answer in any order.

---

## Examples

**Example 1:**

Input: nums = , target = 9
Output:
Explanation: Because nums + nums == 9, we return.

text

**Example 2:**

Input: nums = , target = 6
Output:

text

**Example 3:**

Input: nums = , target = 6
Output:

text

---

## Constraints

- 2 <= nums.length <= 10^4
- -10^9 <= nums[i] <= 10^9
- -10^9 <= target <= 10^9
- Only one valid answer exists.

---

## Follow-up

*Can you come up with an algorithm that is less than O(n²) time complexity?*

---

## Java Solution

import java.util.*;

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

text

---

## Test Cases & Dry Run

### Testcase 1

Input: `nums = [2,7,11,15], target = 9`

| Step | i | nums[i] | complement | map         | map.containsKey | Return |
|------|---|---------|------------|-------------|-----------------|--------|
| 1    | 0 | 2       | 7          | {}          | false           |        |
| 2    | 1 | 7       | 2          | {2:0}       | true            | [0,1]  |

**Output:** `[0,1]`

---

### Testcase 2

Input: `nums = [3,2,4], target = 6`

| Step | i | nums[i] | complement | map     | map.containsKey | Return |
|------|---|---------|------------|---------|-----------------|--------|
| 1    | 0 | 3       | 3          | {}      | false           |        |
| 2    | 1 | 2       | 4          | {3:0}   | false           |        |
| 3    | 2 | 4       | 2          | {3:0,2:1}| true           | [1,2]  |

**Output:** `[1,2]`

---

### Testcase 3

Input: `nums = [3,3], target = 6`

| Step | i | nums[i] | complement | map   | map.containsKey | Return |
|------|---|---------|------------|-------|-----------------|--------|
| 1    | 0 | 3       | 3          | {}    | false           |        |
| 2    | 1 | 3       | 3          | {3:0} | true            | [0,1]  |

**Output:** `[0,1]`

---

### Testcase 4

Input: `nums = [1,5,7,2], target = 6`

| Step | i | nums[i] | complement | map   | map.containsKey | Return |
|------|---|---------|------------|-------|-----------------|--------|
| 1    | 0 | 1       | 5          | {}    | false           |        |
| 2    | 1 | 5       | 1          | {1:0} | true            | [0,1]  |

**Output:** `[0,1]`

---

### Testcase 5

Input: `nums = [-1,0,1,2], target = 1`

| Step | i | nums[i] | complement | map           | map.containsKey | Return |
|------|---|---------|------------|---------------|-----------------|--------|
| 1    | 0 | -1      | 2          | {}            | false           |        |
| 2    | 1 | 0       | 1          | {-1:0}        | false           |        |
| 3    | 2 | 1       | 0          | {-1:0,0:1}    | true            | [1,2]  |

**Output:** `[1,2]`

---

## Main Class for Multiple Testcases

public class Main {
public static void main(String[] args) {
Solution solution = new Solution();
int[][] testNums = {
{2,7,11,15},
{3,2,4},
{3,3},
{1,5,7,2},
{-1,0,1,2}
};
int[] targets = {9, 6, 6, 6, 1};

text
    for (int i = 0; i < testNums.length; i++) {
        int[] result = solution.twoSum(testNums[i], targets[i]);
        System.out.println("Output for Testcase " + (i+1) + ": " + Arrays.toString(result));
    }
}
}

text

---

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`