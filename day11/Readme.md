## Problem Overview

You are given an array of `n` strings, all having the same length. These strings can be visualized as a **grid**, where:

* Each string represents a **row**
* Each character position represents a **column**

Your task is to **count how many columns are not sorted lexicographically (top to bottom)**. Any column that is not sorted must be deleted.

---

## What Does "Lexicographically Sorted" Mean?

A column is considered **sorted** if the characters from the top row to the bottom row are in **non-decreasing alphabetical order**.

Example of a sorted column:

```
a
b
c
```

Example of an unsorted column:

```
b
c
a
```

---

## Key Observation

* Since all strings have the same length, every column index is valid for all rows.
* Each column can be checked **independently**.
* A column is invalid **as soon as** we find a character smaller than the one above it.

---

## Approach 1: Column-wise Comparison (Optimal & Simple)

### Steps

1. Count the number of rows (`n`) and columns (`m`).
2. For each column:

   * Compare characters row by row (from top to bottom).
   * If `strs[row][col] < strs[row - 1][col]`, the column is **not sorted**.
3. Increment the deletion counter and move to the next column.

### Why This Works

* Lexicographical order only depends on **adjacent comparisons**.
* Once a column fails, no further checking is required.

---

## Java Implementation

```java
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;          // number of rows
        int m = strs[0].length();     // number of columns
        int ans = 0;

        for (int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    ans++;           // this column must be deleted
                    break;           // no need to check further rows
                }
            }
        }

        return ans;
    }
}
```

---

## Dry Run (Example 1)

### Input

```
strs = ["cba", "daf", "ghi"]
```

### Grid Representation

```
col:  0   1   2
     -----------
      c   b   a
      d   a   f
      g   h   i
```

---

### Column 0

* c → d → g (sorted)
* ✔ Keep column

### Column 1

* b → a ❌ (a < b)
* ✖ Delete column

### Column 2

* a → f → i (sorted)
* ✔ Keep column

---

### Final Answer

```
Deleted columns = 1
```

---

## Time and Space Complexity

* **Time Complexity:** `O(n × m)`

  * Each character is checked at most once.
* **Space Complexity:** `O(1)`

  * Only a counter variable is used.

---

## Alternative Ways to Think About the Problem

### 1. Brute Force (Same Logic)

* Convert the grid into a 2D character array.
* Check each column independently.
* Same complexity, more memory usage.

### 2. Functional / Stream-based Approach (Java Streams)

* Can be written using streams for elegance.
* Less readable and not faster than loops.

---

## Final Notes

* This problem is mainly about **careful traversal** of a 2D structure.
* Early termination (`break`) improves efficiency.
* The provided solution is **optimal, clean, and interview-ready**.

---

✅ This method works efficiently within the given constraints.
