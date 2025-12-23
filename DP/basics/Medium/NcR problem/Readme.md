# 📘 Compute nCr (Combination)

## 🔹 Problem Statement

Given two integers **n** and **r**, compute the value of **nCr** (number of ways to choose r elements from n elements).

The formula is:

> **nCr = n! / (r! × (n − r)!)**

Since the result can be very large, output the answer **modulo 1000000007**.

### ⚠️ Important Note

* You **must not use BigInteger**.
* You need an efficient approach because constraints are large.

---

## 🔹 Input Format

* First line contains integer **T** – number of test cases
* Next **T** lines contain two integers **N** and **R**

## 🔹 Output Format

* For each test case, print **nCr % 1000000007**

---

## 🔹 Constraints

| Points | T       | N, R   |
| ------ | ------- | ------ |
| 20 pts | ≤ 100   | ≤ 30   |
| 80 pts | ≤ 5×10⁵ | ≤ 2000 |

---

## 🔹 Example

**Input**

```
5
4 2
3 1
25 12
30 14
6 4
```

**Output**

```
6
3
5200300
145422675
15
```

---

# 🚀 Approaches to Solve nCr

We will discuss **three approaches**, increasing in efficiency.

---

## ✅ Approach 1: Direct Formula (Factorial)

### Idea

Compute:

```
nCr = n! / (r! × (n − r)!)
```

### ❌ Why it fails

* Factorials grow extremely fast
* Overflow occurs even with `long`
* Division modulo is tricky
* Too slow for large inputs

### ⏱ Time Complexity

* Per test case: **O(n)**
* Overall: **O(T × N)** ❌

👉 **Not recommended** for given constraints.

---

## ✅ Approach 2: Pascal's Identity (Dynamic Programming)

### 🧠 Mathematical Identity

```
C(n, r) = C(n−1, r−1) + C(n−1, r)
```

Base cases:

```
C(n, 0) = 1
C(n, n) = 1
```

---

### 🧩 DP Table Meaning

Let:

```
dp[n][r] = nCr % MOD
```

We precompute all values up to **n = 2000** once.

---

### 🔁 DP Construction

```
for n = 0 to 2000:
    dp[n][0] = 1
    dp[n][n] = 1

for n = 1 to 2000:
    for r = 1 to n-1:
        dp[n][r] = (dp[n-1][r-1] + dp[n-1][r]) % MOD
```

---

### 🧪 Dry Run (Example: n = 4, r = 2)

Pascal Triangle:

```
Row 0: 1
Row 1: 1 1
Row 2: 1 2 1
Row 3: 1 3 3 1
Row 4: 1 4 6 4 1
```

➡️ **Answer = dp[4][2] = 6** ✅

---

### ⏱ Time & Space Complexity

| Type           | Complexity    |
| -------------- | ------------- |
| Precomputation | O(N²) = 4×10⁶ |
| Each Query     | O(1)          |
| Space          | O(N²)         |

✔ Perfect for **large T (5×10⁵)**

---

### 💡 Why This Works Well

* No division
* No overflow
* Very fast queries
* Precompute once, answer instantly

---

### ✅ Java Code (DP – Pascal's Triangle)

```java
import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;
    static final int MAX = 2000;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        long[][] dp = new long[MAX + 1][MAX + 1];

        // Base cases
        for (int i = 0; i <= MAX; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
        }

        // Pascal DP
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            sb.append(dp[n][r]).append('\n');
        }
        System.out.print(sb.toString());
    }
}
```

---

## ✅ Approach 3: Factorial + Modular Inverse (Advanced)

### Idea

Use:

```
nCr = fact[n] × invFact[r] × invFact[n-r] % MOD
```

Where modular inverse uses **Fermat's Little Theorem**:

```
a^(MOD-2) % MOD
```

### ⏱ Complexity

| Step                  | Complexity |
| --------------------- | ---------- |
| Precompute factorials | O(N)       |
| Each Query            | O(1)       |
| Space                 | O(N)       |

⚠️ More complex but very efficient

---

## 🏆 Best Choice for This Problem

| Method         | Suitable?             |
| -------------- | --------------------- |
| Direct Formula | ❌ No                  |
| DP (Pascal)    | ✅ YES (Best & Simple) |
| Mod Inverse    | ✅ YES (Advanced)      |

👉 **Your DP solution is 100% correct and optimal for this problem** ✅

---

## 🎯 Key Takeaways

* Use **Pascal’s Identity** to avoid division
* Precompute once → answer fast
* Always think about constraints before coding

---
