# Day 1: Majority Element (>n/3)

## Problem Statement
Given an integer array of size n, find all elements that appear more than ⌊n/3⌋ times.

**Constraints:**
- 1 ≤ n ≤ 5 * 10^4
- -10^9 ≤ nums[i] ≤ 10^9
- The algorithm should run in linear time and use only constant extra space

**Follow up:** Could you solve the problem in linear time and in O(1) space?

## Approach

### Boyer-Moore Voting Algorithm (Modified)

Since there can be at most 2 elements that appear more than ⌊n/3⌋ times, we can use a modified Boyer-Moore voting algorithm:

1. **First Pass:** Find two potential candidates using voting
   - Initialize two candidates and their counts
   - Iterate through array:
     - If element matches candidate1, increment count1
     - Else if element matches candidate2, increment count2
     - Else if count1 is 0, set candidate1 and count1 = 1
     - Else if count2 is 0, set candidate2 and count2 = 1
     - Else decrement both counts

2. **Second Pass:** Verify candidates actually appear > n/3 times
   - Count occurrences of each candidate
   - Add to result if count > n/3

**Time Complexity:** O(n)
**Space Complexity:** O(1)

## Code Implementation

```java
import java.util.*;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return result;
        
        // Step 1: Find potential candidates
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        
        for (int num : nums) {
            if (count1 > 0 && num == candidate1) {
                count1++;
            } else if (count2 > 0 && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        
        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;
        
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }
        
        int threshold = nums.length / 3;
        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);
        
        return result;
    }
}
```

## Dry Run Examples

### Example 1: [3,2,3]
**Array:** [3,2,3], **Length:** 3, **Threshold:** 3/3 = 1

#### Phase 1: Finding Candidates
| Index | Element | Candidate1 | Count1 | Candidate2 | Count2 | Action |
|-------|---------|------------|--------|------------|--------|---------|
| 0 | 3 | 0 | 0 | 0 | 0 | count1 == 0, set candidate1=3, count1=1 |
| 1 | 2 | 3 | 1 | 0 | 0 | count2 == 0, set candidate2=2, count2=1 |
| 2 | 3 | 3 | 1 | 2 | 1 | matches candidate1, count1++ |

**Final candidates:** candidate1=3, candidate2=2

#### Phase 2: Verification
| Element | Count of 3 | Count of 2 |
|---------|------------|-------------|
| 3 | 1 | 0 |
| 2 | 1 | 1 |
| 3 | 2 | 1 |

**Result:** [3] (count of 3 = 2 > threshold 1)

---

### Example 2: [1]
**Array:** [1], **Length:** 1, **Threshold:** 1/3 = 0

#### Phase 1: Finding Candidates
| Index | Element | Candidate1 | Count1 | Candidate2 | Count2 | Action |
|-------|---------|------------|--------|------------|--------|---------|
| 0 | 1 | 0 | 0 | 0 | 0 | count1 == 0, set candidate1=1, count1=1 |

**Final candidates:** candidate1=1, candidate2=0

#### Phase 2: Verification
| Element | Count of 1 | Count of 0 |
|---------|------------|-------------|
| 1 | 1 | 0 |

**Result:** [1] (count of 1 = 1 > threshold 0)

---

### Example 3: [1,2]
**Array:** [1,2], **Length:** 2, **Threshold:** 2/3 = 0

#### Phase 1: Finding Candidates
| Index | Element | Candidate1 | Count1 | Candidate2 | Count2 | Action |
|-------|---------|------------|--------|------------|--------|---------|
| 0 | 1 | 0 | 0 | 0 | 0 | count1 == 0, set candidate1=1, count1=1 |
| 1 | 2 | 1 | 1 | 0 | 0 | count2 == 0, set candidate2=2, count2=1 |

**Final candidates:** candidate1=1, candidate2=2

#### Phase 2: Verification
| Element | Count of 1 | Count of 2 |
|---------|------------|-------------|
| 1 | 1 | 0 |
| 2 | 1 | 1 |

**Result:** [1,2] (both counts = 1 > threshold 0)

## Key Insights

1. **At most 2 elements** can appear more than n/3 times in any array
2. **Boyer-Moore algorithm** efficiently finds candidates in O(n) time with O(1) space
3. **Two-pass approach** ensures we verify candidates actually meet the threshold
4. **Edge cases** like single element arrays and arrays where all elements qualify need special handling

## Complexity Analysis

- **Time Complexity:** O(n) - Two passes through the array
- **Space Complexity:** O(1) - Only using constant extra variables (excluding output list)
- **Optimal Solution:** Yes, this meets the follow-up requirement for linear time and constant space