# 📦 Minimum Number of Boxes to Redistribute Apples

## 🧩 Problem Statement
You are given:
- An array `apple[]` of size `n`, where `apple[i]` represents the number of apples in the `iᵗʰ` pack.
- An array `capacity[]` of size `m`, where `capacity[i]` represents the maximum number of apples the `iᵗʰ` box can hold.

You are allowed to distribute apples from the same pack into multiple boxes.

### 🎯 Objective
Return the **minimum number of boxes** required to store **all apples**.

---

## 💡 Approach Type: Greedy Algorithm

### Why Greedy?
To minimize the number of boxes used, we should always choose the **boxes with the largest capacity first**.  
This ensures we cover the total number of apples using the fewest boxes.

---

## 🛠️ Algorithm
1. Calculate the total number of apples.
2. Sort the `capacity` array in **descending order**.
3. Keep selecting boxes (from largest capacity) and subtract their capacity from the total apples.
4. Stop when all apples are placed.
5. The number of selected boxes is the answer.

---

## 🧪 Dry Run (Example 1)

### Input
apple = [1, 3, 2]
capacity = [4, 3, 1, 5, 2]

shell
Copy code

### Step 1: Total apples
1 + 3 + 2 = 6

graphql
Copy code

### Step 2: Sort capacity in descending order
[5, 4, 3, 2, 1]

shell
Copy code

### Step 3: Select boxes greedily

| Box Count | Capacity Used | Remaining Apples |
|----------|--------------|------------------|
| 1        | 5            | 6 - 5 = 1        |
| 2        | 4            | 1 - 4 = -3 (done)|

### ✅ Result
Minimum boxes required = 2

yaml
Copy code

---

## ⏱️ Complexity Analysis

- **Time Complexity:** `O(m log m)` (sorting the capacity array)
- **Space Complexity:** `O(1)` (in-place sorting)

---

## ✅ Java Code (Greedy Approach)

```java
import java.util.Arrays;

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        // Step 1: Calculate total apples
        int totalApples = 0;
        for (int a : apple) {
            totalApples += a;
        }

        // Step 2: Sort capacities in descending order
        Arrays.sort(capacity);
        int m = capacity.length;
        for (int i = 0; i < m / 2; i++) {
            int temp = capacity[i];
            capacity[i] = capacity[m - 1 - i];
            capacity[m - 1 - i] = temp;
        }

        // Step 3: Pick boxes greedily
        int boxesUsed = 0;
        for (int cap : capacity) {
            totalApples -= cap;
            boxesUsed++;
            if (totalApples <= 0) {
                break;
            }
        }

        return boxesUsed;
    }
}
