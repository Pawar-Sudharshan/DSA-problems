# 🧗 Climbing Stairs – Complete Explanation

---

## 📌 Problem Statement

You are climbing a staircase with **n steps**.

* At each move, you can climb either **1 step** or **2 steps**.
* You need to find the number of **distinct ways** to reach the top.

### Examples

**Example 1**

```
Input: n = 2
Output: 2
```

**Explanation:**

1. 1 step + 1 step
2. 2 steps

**Example 2**

```
Input: n = 3
Output: 3
```

**Explanation:**

1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

### Constraints

```
1 ≤ n ≤ 45
```

---

## 🧠 Key Observation

To reach step **n**:

* You can come from step **n−1** by taking 1 step
* Or from step **n−2** by taking 2 steps

So the total number of ways is:

```
ways(n) = ways(n-1) + ways(n-2)
```

This follows the **Fibonacci sequence** pattern.

---

## 🔴 Approach 1: Brute Force (Recursion)

### 🔹 Idea

Try all possible combinations recursively:

* Take 1 step
* Take 2 steps

### 🔹 Algorithm

```
ways(n) = ways(n-1) + ways(n-2)
```

### 🔹 Code (Brute Force)

```java
class Solution {
    public int climbStairs(int n) {
        if (n <= 1)
            return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```

### 🔹 Complexity Analysis

* **Time Complexity:** O(2ⁿ) ❌
* **Space Complexity:** O(n) (recursion stack)

### ❌ Drawback

* Recomputes the same subproblems
* Very slow for large `n`

---

## 🟡 Approach 2: Moderate Optimized (Dynamic Programming – Tabulation)

### 🔹 Idea

Store the results of subproblems in an array to avoid repeated computation.

### 🔹 Steps

1. Create a DP array `dp[]`
2. Define base cases
3. Build solution bottom-up

### 🔹 Code (DP – Tabulation)

```java
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at step 0
        dp[1] = 1; // 1 way to reach step 1
        dp[2] = 2; // 2 ways to reach step 2

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
```

### 🔹 Complexity Analysis

* **Time Complexity:** O(n) ✅
* **Space Complexity:** O(n) ⚠️

### ✔️ Advantage

* Efficient
* Easy to understand
* Avoids repeated calculations

---

## 🟢 Approach 3: Optimized Solution (Space Optimized DP)

### 🔹 Idea

Only the last two values are required instead of the full DP array.

### 🔹 Steps

1. Use two variables
2. Update values iteratively

### 🔹 Code (Optimized)

```java
class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;

        int prev1 = 2; // ways to reach step 2
        int prev2 = 1; // ways to reach step 1

        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
```

### 🔹 Complexity Analysis

* **Time Complexity:** O(n) ✅
* **Space Complexity:** O(1) ✅

### ⭐ Best Approach

* Most efficient
* Interview preferred

---

## 📊 Comparison Summary

| Approach        | Time Complexity | Space Complexity | Status        |
| --------------- | --------------- | ---------------- | ------------- |
| Brute Force     | O(2ⁿ)           | O(n)             | ❌ Inefficient |
| DP (Tabulation) | O(n)            | O(n)             | ✅ Good        |
| Optimized DP    | O(n)            | O(1)             | ⭐ Best        |

---

## ✅ Final Takeaways

* This is a **classic Dynamic Programming** problem
* It follows the **Fibonacci pattern**
* Always optimize space when possible
* The optimized DP approach is best for real-world use and interviews

---

✨ End of Document
