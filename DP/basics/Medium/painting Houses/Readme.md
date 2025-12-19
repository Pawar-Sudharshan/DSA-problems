# 🎨 Painting Houses – Dynamic Programming Solution

## 📌 Problem Statement

There is a line of **N houses**, and each house can be painted with **one of three colors**:

* **Red**
* **Green**
* **Blue**

The cost of painting each house with a specific color is given. The goal is to **paint all houses** such that:

* ❌ No two **adjacent houses** have the **same color**
* ✅ The **total painting cost is minimized**

---

## 🧾 Input Format

* First line contains **T** – number of test cases
* For each test case:

  * One line with **N** – number of houses
  * One line with **N integers** → cost of painting each house **Red**
  * One line with **N integers** → cost of painting each house **Green**
  * One line with **N integers** → cost of painting each house **Blue**

---

## 🖨️ Output Format

For each test case, print the **minimum total cost** to paint all houses.

---

## 🔒 Constraints

* `1 ≤ T ≤ 100`
* `1 ≤ N ≤ 10^3`
* `1 ≤ R[i], G[i], B[i] ≤ 10^3`

---

## 🧠 Approach – Dynamic Programming

We use **Dynamic Programming** to track the minimum cost of painting houses up to index `i`, with each possible color.

### DP States

* `dpR[i]` → Minimum cost to paint first `i` houses **ending with Red**
* `dpG[i]` → Minimum cost to paint first `i` houses **ending with Green**
* `dpB[i]` → Minimum cost to paint first `i` houses **ending with Blue**

### Transition

To paint house `i`:

* If house `i` is **Red**, previous house must be **Green or Blue**
* If house `i` is **Green**, previous house must be **Red or Blue**
* If house `i` is **Blue**, previous house must be **Red or Green**

### Recurrence Relations

```text
dpR[i] = R[i-1] + min(dpG[i-1], dpB[i-1])
dpG[i] = G[i-1] + min(dpR[i-1], dpB[i-1])
dpB[i] = B[i-1] + min(dpR[i-1], dpG[i-1])
```

### Final Answer

```text
min(dpR[n], dpG[n], dpB[n])
```

---

## 💻 Java Implementation

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int[] R = new int[n];
            int[] G = new int[n];
            int[] B = new int[n];

            for (int i = 0; i < n; i++) R[i] = sc.nextInt();
            for (int i = 0; i < n; i++) G[i] = sc.nextInt();
            for (int i = 0; i < n; i++) B[i] = sc.nextInt();

            int[] dpR = new int[n + 1];
            int[] dpG = new int[n + 1];
            int[] dpB = new int[n + 1];

            dpR[0] = dpG[0] = dpB[0] = 0;

            for (int i = 1; i <= n; i++) {
                dpR[i] = R[i - 1] + Math.min(dpG[i - 1], dpB[i - 1]);
                dpG[i] = G[i - 1] + Math.min(dpR[i - 1], dpB[i - 1]);
                dpB[i] = B[i - 1] + Math.min(dpR[i - 1], dpG[i - 1]);
            }

            int ans = Math.min(dpR[n], Math.min(dpG[n], dpB[n]));
            System.out.println(ans);
        }
    }
}
```

---

## 🧪 Example

**Input**

```
1
6
7 3 8 6 1 2
5 6 7 2 4 3
10 1 4 9 7 6
```

**Output**

```
18
```

**Explanation**

* House 1 → Green
* House 2 → Red
* House 3 → Blue
* House 4 → Green
* House 5 → Red
* House 6 → Green

Total cost = `5 + 3 + 4 + 2 + 1 + 3 = 18`

---

## ⏱️ Complexity Analysis

* **Time Complexity:** `O(N)` per test case
* **Space Complexity:** `O(N)`

---

## ✅ Key Takeaways

* Classic **DP coloring problem**
* Prevent adjacent color repetition using DP state separation
* Easily extensible to more colors

---

📌 *This solution is clean, efficient, and suitable for competitive programming and interviews.*
