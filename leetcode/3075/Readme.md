# 🌟 Maximum Happiness Sum (Greedy Problem)

## 📌 Problem Statement

You are given an integer array `happiness` of length `n`, where `happiness[i]` represents the happiness value of the *i-th* child standing in a queue. You are also given a positive integer `k`.

You must select **exactly `k` children** in `k` turns.

### Rules:

* In each turn, you select **one child**.
* After selecting a child, the happiness value of **all unselected children decreases by 1**.
* Happiness values **cannot go below 0**.

### Goal:

Return the **maximum possible sum** of happiness values of the selected `k` children.

---

## 🧠 Key Insight

Each time you select a child, future selections become less valuable because remaining children lose happiness. So, to **maximize total happiness**, we should:

👉 Always pick the child with the **maximum current happiness** first.

This naturally leads to a **greedy strategy**.

---

## 🚀 Approaches

## 1️⃣ Brute Force Approach (Conceptual – Not Practical)

### 💡 Idea

Try **all possible ways** of selecting `k` children in different orders and calculate the maximum happiness sum.

### ❌ Why it fails

* Number of ways = `n! / (n-k)!`
* Extremely large for `n` up to `2 × 10⁵`
* **Time Limit Exceeded**

### ⏱️ Time Complexity

`O(n!)` → ❌ Not feasible

---

## 2️⃣ Better Approach (Simulation with Priority Queue)

### 💡 Idea

* Use a **max heap** (priority queue)
* Each time:

  * Pick the maximum happiness
  * Decrease remaining elements by 1

### ❌ Problem

* Updating all remaining values every time is expensive

### ⏱️ Time Complexity

`O(k × n)` → ❌ Still too slow

---

## 3️⃣ ✅ Best & Optimal Approach (Greedy + Sorting)

### 💡 Key Observation

After selecting `i` children:

* Every remaining child's happiness has decreased by `i`

So, if we sort happiness in **descending order**, then:

👉 Contribution of `i-th` selected child = `max(happiness[i] - i, 0)`

---

## 🧪 Dry Run (Example)

### Example

```
happiness = [1, 2, 3]
k = 2
```

### Step 1: Sort in descending order

```
[3, 2, 1]
```

### Step 2: Pick k children

| Turn (i) | happiness[i] | happiness[i] - i | Added to sum |
| -------- | ------------ | ---------------- | ------------ |
| 0        | 3            | 3 - 0 = 3        | ✅ 3          |
| 1        | 2            | 2 - 1 = 1        | ✅ 1          |

### Final Answer

```
3 + 1 = 4
```

---

## 🧮 Algorithm

1. Sort the `happiness` array in **descending order**
2. Initialize `ans = 0`
3. For `i` from `0` to `k-1`:

   * Compute `value = happiness[i] - i`
   * If `value <= 0`, break
   * Add `value` to `ans`
4. Return `ans`

---

## 💻 Java Code (Optimal Solution)

```java
class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        
        // Sort the array
        Arrays.sort(happiness);
        
        // Reverse to get descending order
        for (int i = 0; i < n / 2; i++) {
            int temp = happiness[i];
            happiness[i] = happiness[n - 1 - i];
            happiness[n - 1 - i] = temp;
        }
        
        long ans = 0;
        
        // Select k children
        for (int i = 0; i < k; i++) {
            long value = (long) happiness[i] - i;
            if (value <= 0) break;
            ans += value;
        }
        
        return ans;
    }
}
```

---

## ⏱️ Complexity Analysis

| Metric           | Value                        |
| ---------------- | ---------------------------- |
| Time Complexity  | `O(n log n)`                 |
| Space Complexity | `O(1)` (ignoring sort space) |

---

## 🎯 Final Takeaway

* Always **pick the happiest child first**
* Use **sorting + greedy** to avoid simulation
* Subtract turns (`i`) to account for happiness decay

✅ Clean, fast, and interview-ready solution!

---

📌 *Perfect example of turning a simulation problem into a greedy math-based solution.*
