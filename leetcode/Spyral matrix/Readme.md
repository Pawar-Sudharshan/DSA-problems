# 🌀 Spiral Matrix (LeetCode)

## 📌 Problem Statement

You are given an `m × n` matrix. Your task is to return **all elements of the matrix in spiral order**.

### Spiral Order Means:

* Start from the **top-left corner**
* Move **right** → **down** → **left** → **up**
* Continue this process inward until all elements are visited

---

## 📥 Input Format

* An integer matrix `matrix` of size `m × n`

## 📤 Output Format

* A list containing elements of the matrix in spiral order

---

## 🧠 Key Insight

A spiral traversal is controlled by **four boundaries**:

* `top` row
* `bottom` row
* `left` column
* `right` column

After traversing one direction, we **shrink the boundary**.

---

## 🚀 Approaches

## 1️⃣ Brute Force Approach (Visited Matrix)

### 💡 Idea

* Use an extra `visited[][]` matrix
* Move in spiral directions
* Change direction when you hit a boundary or visited cell

### ❌ Drawbacks

* Extra space usage
* Direction logic is messy

### ⏱ Complexity

* Time: `O(m × n)`
* Space: `O(m × n)` ❌

### 🧪 Dry Run (Example)

Matrix:

```
1  2  3
4  5  6
7  8  9
```

Traversal:

```
Right → Down → Left → Up
Result: 1 2 3 6 9 8 7 4 5
```

---

## 2️⃣ Optimal Approach (Boundary Traversal)

### 💡 Idea

Instead of marking visited cells, control the traversal using **shrinking boundaries**.

Maintain:

```
top = 0
bottom = m - 1
left = 0
right = n - 1
```

Traverse while `top <= bottom` and `left <= right`.

---

## 🧪 Dry Run (Example)

Matrix:

```
1  2  3
4  5  6
7  8  9
```

### Step-by-step Traversal

1️⃣ Left → Right (top row)

```
1 2 3
```

`top++`

2️⃣ Top → Bottom (right column)

```
6 9
```

`right--`

3️⃣ Right → Left (bottom row)

```
8 7
```

`bottom--`

4️⃣ Bottom → Top (left column)

```
4
```

`left++`

Remaining:

```
5
```

Final Order:

```
1 2 3 6 9 8 7 4 5
```

---

## 3️⃣ ✅ Best & Optimal Approach (Final)

* No extra space
* Clean logic
* Interview-preferred

---

## 🧮 Algorithm

1. Initialize `top`, `bottom`, `left`, `right`
2. While `top <= bottom && left <= right`:

   * Traverse top row (left → right)
   * Traverse right column (top → bottom)
   * If `top <= bottom`, traverse bottom row (right → left)
   * If `left <= right`, traverse left column (bottom → top)
3. Shrink boundaries after each traversal

---

## 💻 Java Code (LeetCode Compatible)

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // left to right
            for (int j = left; j <= right; j++)
                res.add(matrix[top][j]);
            top++;

            // top to bottom
            for (int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
            right--;

            // right to left
            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    res.add(matrix[bottom][j]);
                bottom--;
            }

            // bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }
        return res;
    }
}
```

---

## ⏱ Complexity Analysis

| Metric | Value                     |
| ------ | ------------------------- |
| Time   | `O(m × n)`                |
| Space  | `O(1)` (excluding output) |

---

## 🎯 Final Takeaways

* Spiral traversal = **boundary control**
* Avoid visited matrix if possible
* Always check boundaries before traversing

📌 *A classic matrix problem frequently asked in interviews.*
