# 🍎 Collect Apples (Dynamic Programming)

## 📌 Problem Statement

You are given a maze (grid) of size **N × M**, where each cell contains some apples.

You start from the **top-left cell (0,0)** and want to reach the **bottom-right cell (N−1,M−1)**.

### Rules

* From any cell `(i, j)`, you can move only:

  * 👉 **Right** → `(i, j + 1)`
  * 👉 **Down** → `(i + 1, j)`
* When you visit a cell, you collect all apples in that cell.

### Objective

Find the **maximum number of apples** you can collect while reaching the bottom-right cell.

---

## 📥 Input Format

* First line: `T` — number of test cases
* For each test case:

  * First line: `N M`
  * Next `N` lines: `M` integers each (`A[i][j]`)

## 📤 Output Format

For each test case, print the **maximum apples collected**.

---

## 🧠 Key Insight

At every cell, you must have come from either:

* the **top cell**, or
* the **left cell**

So the best path to a cell depends on the **best paths to those two cells**.

This is a classic **Dynamic Programming on Grid** problem.

---

## 🚀 Approaches

## 1️⃣ Brute Force Approach (Recursive)

### 💡 Idea

* From `(0,0)`, try **all possible paths** to `(N-1,M-1)`
* At each cell, move either **right** or **down**
* Track maximum apples collected

### ❌ Why it fails

* Number of paths = combinatorial (`(N+M)!`)
* Massive recomputation of same states

### ⏱ Time Complexity

`O(2^(N+M))` ❌ (TLE)

### 🧪 Dry Run (Small Example)

```
1 2
3 4
```

Paths:

* Right → Down → sum = 1+2+4
* Down → Right → sum = 1+3+4

Pick maximum.

---

## 2️⃣ Optimal Approach (Dynamic Programming)

### 💡 Idea

Let `dp[i][j]` = **maximum apples collected to reach cell `(i,j)`**

Transition:

```
dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + A[i][j]
```

### Base Case

```
dp[0][0] = A[0][0]
```

---

## 🧪 Dry Run (Example)

### Input

```
3 4
1 5 1 4
10 11 0 13
4 15 1 12
```

### DP Table Construction

```
 1   6   7  11
11  22  22  35
15  37  38  50
```

### Final Answer

```
50
```

---

## 3️⃣ ✅ Best & Optimal Approach (DP – Final)

* No recursion
* No repeated calculations
* Direct bottom-up computation

---

## 🧮 Algorithm

1. Read input grid
2. Create DP table of size `N × M`
3. Initialize `dp[0][0] = A[0][0]`
4. For each cell `(i,j)`:

   * If first row → can come only from left
   * If first column → can come only from top
   * Else → take max of top & left
5. Print `dp[N-1][M-1]`

---

## 💻 Java Code (Best Solution)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] A = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            long[][] dp = new long[n][m];
            dp[0][0] = A[0][0];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 && j == 0) continue;
                    long fromTop = (i > 0) ? dp[i - 1][j] : 0;
                    long fromLeft = (j > 0) ? dp[i][j - 1] : 0;
                    dp[i][j] = Math.max(fromTop, fromLeft) + A[i][j];
                }
            }

            System.out.println(dp[n - 1][m - 1]);
        }
        sc.close();
    }
}
```

---

## ⏱ Complexity Analysis

| Metric | Value      |
| ------ | ---------- |
| Time   | `O(N × M)` |
| Space  | `O(N × M)` |

---

## 🎯 Final Takeaway

* Grid + max path → **Dynamic Programming**
* Each cell depends only on **top & left**
* Clean, fast, and interview-friendly

📌 *A must-know DP pattern for coding interviews.*
