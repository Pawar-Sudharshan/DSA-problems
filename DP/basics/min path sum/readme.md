# 🧮 Minimum Path Sum (Dynamic Programming)

## 📌 Problem Statement

Given a `m x n` grid filled with **non-negative integers**, find a path from the **top-left cell `(0,0)`** to the **bottom-right cell `(m-1,n-1)`** such that the **sum of all numbers along the path is minimum**.

### 🔹 Movement Rules
- You can move **only right or down** at any point in time.

---

## ✨ Examples

### Example 1

**Input**
grid = [[1,3,1],
[1,5,1],
[4,2,1]]

markdown
Copy code

**Output**
7

csharp
Copy code

**Explanation**

The minimum path is:
1 → 3 → 1 → 1 → 1

yaml
Copy code

---

### Example 2

**Input**
grid = [[1,2,3],
[4,5,6]]

markdown
Copy code

**Output**
12

yaml
Copy code

---

## 🔍 Constraints

- `1 ≤ m, n ≤ 200`
- `0 ≤ grid[i][j] ≤ 200`

---

## 🧠 Approach: Dynamic Programming (Top-Down with Memoization)

### Key Idea

To reach a cell `(i, j)`, the path must come from one of the following:
- From **top** → `(i-1, j)`
- From **left** → `(i, j-1)`

So, the minimum path sum to reach `(i, j)` is:

grid[i][j] + min(path from top, path from left)

yaml
Copy code

---

## 🧱 Subproblem Definition

Let:
dp[i][j] = minimum path sum to reach cell (i, j)

yaml
Copy code

---

## 🛑 Base Case

dp[0][0] = grid[0][0]

yaml
Copy code

---

## 🔁 Recurrence Relation

dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1])

pgsql
Copy code

If `(i-1, j)` or `(i, j-1)` is out of bounds, its value is treated as `∞` (or `Integer.MAX_VALUE`).

---

## 🚀 Why Memoization?

Without memoization, the recursive solution recomputes the same subproblems multiple times, leading to **exponential time complexity**.

Using a `dp[][]` array ensures that **each cell is computed only once**, making the solution efficient.

---

## ✅ Java Implementation (Top-Down DP)

```java
class Solution {
    public static int dp[][];

    public static int solve(int[][] mat, int i, int j) {
        // Base case
        if (i == 0 && j == 0) return mat[0][0];

        // If already computed
        if (dp[i][j] != -1) return dp[i][j];

        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;

        if (j > 0) left = solve(mat, i, j - 1);
        if (i > 0) top = solve(mat, i - 1, j);

        dp[i][j] = mat[i][j] + Math.min(left, top);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(grid, n - 1, m - 1);
    }
}
⏱ Time and Space Complexity
Complexity Type	Value
Time Complexity	O(m × n)
Space Complexity	O(m × n)

📝 Summary
This is a classic Dynamic Programming grid problem

The solution uses top-down DP with memoization

Only right and down moves are allowed

Efficient and works within given constraints