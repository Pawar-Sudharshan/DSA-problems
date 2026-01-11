# Day 5: Intersection of Two Linked Lists

Problem reference: [Leetcode 160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)

---

## Problem Statement

You are given the heads of two singly linked-lists `headA` and `headB`.<br>
Return the **node at which the two lists intersect**. If the two linked lists have no intersection at all, return `null`.

#### Note

- Linked lists must **retain their structure** after the function returns.
- Intersection means nodes share the **same memory reference** (not just the same value).
- The test cases are guaranteed to have **no cycles**.

#### Example 1

Input: intersectVal = 8,
listA = ,
listB = ,
skipA = 2, skipB = 3

Output: Intersected at '8'
Representation:

listA: 4 -> 1

8 -> 4 -> 5
/
listB: 5 -> 6 -> 1

text

#### Example 2

Input: intersectVal = 2, listA = , listB = , skipA = 3, skipB = 1
Output: Intersected at '2'

text

#### Example 3

Input: intersectVal = 0, listA = , listB = , skipA = 3, skipB = 2
Output: No intersection

text

---

## Constraints

- `1 <= m, n <= 3 * 10^4`
- `1 <= Node.val <= 10^5`
- `0 <= skipA < m`
- `0 <= skipB < n`
- `intersectVal` is `0` if no intersection, otherwise: `listA[skipA] == listB[skipB] == intersectVal`

---

## Solution

### **Optimal Approach (O(m + n) time, O(1) space):**

- Use two pointers, each starting at the head of each list.
- Move both pointers forward one node at a time.
- When either pointer hits the end of its list, reset it to the head of the other list.
- Eventually, both pointers will either meet at the intersection node, or null (if no intersection).

**Benefits:**  
This works because by switching head, both pointers traverse the **same number of nodes** (m+n).

---

### Implementation (Java)

**File: `day5/Solution.java`**
/**

Definition for singly-linked list.

public class ListNode {

text
int val;
text
ListNode next;
text
ListNode(int x) {
text
    val = x;
text
    next = null;
text
}
}
*/
public class Solution {
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
ListNode t1 = headA;
ListNode t2 = headB;
if (t1 == null || t2 == null) return null;
while (t1 != t2) {
t1 = (t1 == null) ? headB : t1.next;
t2 = (t2 == null) ? headA : t2.next;
}
return t1;
}
}

text

---

## Dry Run & Representation

### **Test Case 1: Intersection**

listA =
listB =
Starting pointers:
A: 4 B: 5

1

intersection at 8 --> 4 --> 5
/
6--1

text

**Step-by-step:**
- Both pointers move, eventually switch to opposite lists when they hit null.
- Nodes are checked by reference, not by value.
- Both finally arrive at node `8` by reference.

### **Test Case 2: No Intersection**

listA =
listB =
A: 2 -> 6 -> 4
B: 1 -> 5

Pointers reach end and switch lists, but never match by reference, so return null.

text

### **Test Case 3: Early Intersection**

listA: , skipA = 3
listB: , skipB = 1
Intersection at value 2 (reference node).

text

---

## Explanation

- Both pointers travel m + n steps.  
- If lists intersect, they'll meet at the intersection node after at most m+n moves.
- If lists do not intersect, both pointers will be null after m+n steps.

---

## Multiple Test Cases

**Add test cases in `day5/testcases.md`:**

---- TEST CASE 1 ----
listA =
listB =
Expected Output: 8

---- TEST CASE 2 ----
listA =
listB =
Expected Output: null

---- TEST CASE 3 ----
listA =
listB =
Expected Output: 2

text

## Easy Representation Trick

- Draw lists as parallel tracks.  
- When lists share a node (by address), merge the tracks.

---

## Time & Space Complexity

- **Time:** O(m + n)
- **Space:** O(1)
- No extra data structures used, only pointer manipulation.

---

## References

- [Leetcode Problem Statement](https://leetcode.com/problems/intersection-of-two-linked-lists/)
- Dry run images & explanation adapted for clarity.

---
<!---LeetCode Topics Start-->
# LeetCode Topics
## Linked List
|  |
| ------- |
| [0061-rotate-list](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0061-rotate-list) |
| [0206-reverse-linked-list](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0206-reverse-linked-list) |
| [0237-delete-node-in-a-linked-list](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0237-delete-node-in-a-linked-list) |
## Recursion
|  |
| ------- |
| [0206-reverse-linked-list](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0206-reverse-linked-list) |
## Array
|  |
| ------- |
| [0026-remove-duplicates-from-sorted-array](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0026-remove-duplicates-from-sorted-array) |
| [0046-permutations](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0046-permutations) |
| [0066-plus-one](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0066-plus-one) |
| [0081-search-in-rotated-sorted-array-ii](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0081-search-in-rotated-sorted-array-ii) |
| [0085-maximal-rectangle](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0085-maximal-rectangle) |
| [0108-convert-sorted-array-to-binary-search-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0108-convert-sorted-array-to-binary-search-tree) |
| [0152-maximum-product-subarray](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0152-maximum-product-subarray) |
| [0229-majority-element-ii](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0229-majority-element-ii) |
| [0704-binary-search](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0704-binary-search) |
| [0961-n-repeated-element-in-size-2n-array](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0961-n-repeated-element-in-size-2n-array) |
| [1046-last-stone-weight](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1046-last-stone-weight) |
| [1356-sort-integers-by-the-number-of-1-bits](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1356-sort-integers-by-the-number-of-1-bits) |
| [1458-max-dot-product-of-two-subsequences](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1458-max-dot-product-of-two-subsequences) |
| [3074-apple-redistribution-into-boxes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/3074-apple-redistribution-into-boxes) |
## Backtracking
|  |
| ------- |
| [0046-permutations](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0046-permutations) |
## Hash Table
|  |
| ------- |
| [0229-majority-element-ii](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0229-majority-element-ii) |
| [0865-smallest-subtree-with-all-the-deepest-nodes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0865-smallest-subtree-with-all-the-deepest-nodes) |
| [0961-n-repeated-element-in-size-2n-array](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0961-n-repeated-element-in-size-2n-array) |
| [1123-lowest-common-ancestor-of-deepest-leaves](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1123-lowest-common-ancestor-of-deepest-leaves) |
## Sorting
|  |
| ------- |
| [0229-majority-element-ii](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0229-majority-element-ii) |
| [1356-sort-integers-by-the-number-of-1-bits](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1356-sort-integers-by-the-number-of-1-bits) |
| [3074-apple-redistribution-into-boxes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/3074-apple-redistribution-into-boxes) |
## Counting
|  |
| ------- |
| [0229-majority-element-ii](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0229-majority-element-ii) |
| [1356-sort-integers-by-the-number-of-1-bits](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1356-sort-integers-by-the-number-of-1-bits) |
## Dynamic Programming
|  |
| ------- |
| [0085-maximal-rectangle](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0085-maximal-rectangle) |
| [0152-maximum-product-subarray](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0152-maximum-product-subarray) |
| [0712-minimum-ascii-delete-sum-for-two-strings](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0712-minimum-ascii-delete-sum-for-two-strings) |
| [1411-number-of-ways-to-paint-n-3-grid](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1411-number-of-ways-to-paint-n-3-grid) |
| [1458-max-dot-product-of-two-subsequences](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1458-max-dot-product-of-two-subsequences) |
## Binary Search
|  |
| ------- |
| [0081-search-in-rotated-sorted-array-ii](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0081-search-in-rotated-sorted-array-ii) |
| [0704-binary-search](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0704-binary-search) |
## Math
|  |
| ------- |
| [0066-plus-one](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0066-plus-one) |
| [0780-reaching-points](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0780-reaching-points) |
## Two Pointers
|  |
| ------- |
| [0026-remove-duplicates-from-sorted-array](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0026-remove-duplicates-from-sorted-array) |
| [0061-rotate-list](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0061-rotate-list) |
## Greedy
|  |
| ------- |
| [3074-apple-redistribution-into-boxes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/3074-apple-redistribution-into-boxes) |
## Heap (Priority Queue)
|  |
| ------- |
| [1046-last-stone-weight](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1046-last-stone-weight) |
## Divide and Conquer
|  |
| ------- |
| [0108-convert-sorted-array-to-binary-search-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0108-convert-sorted-array-to-binary-search-tree) |
## Tree
|  |
| ------- |
| [0102-binary-tree-level-order-traversal](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0102-binary-tree-level-order-traversal) |
| [0108-convert-sorted-array-to-binary-search-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0108-convert-sorted-array-to-binary-search-tree) |
| [0543-diameter-of-binary-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0543-diameter-of-binary-tree) |
| [0865-smallest-subtree-with-all-the-deepest-nodes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0865-smallest-subtree-with-all-the-deepest-nodes) |
| [1123-lowest-common-ancestor-of-deepest-leaves](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1123-lowest-common-ancestor-of-deepest-leaves) |
| [1161-maximum-level-sum-of-a-binary-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1161-maximum-level-sum-of-a-binary-tree) |
## Binary Search Tree
|  |
| ------- |
| [0108-convert-sorted-array-to-binary-search-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0108-convert-sorted-array-to-binary-search-tree) |
## Binary Tree
|  |
| ------- |
| [0102-binary-tree-level-order-traversal](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0102-binary-tree-level-order-traversal) |
| [0108-convert-sorted-array-to-binary-search-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0108-convert-sorted-array-to-binary-search-tree) |
| [0543-diameter-of-binary-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0543-diameter-of-binary-tree) |
| [0865-smallest-subtree-with-all-the-deepest-nodes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0865-smallest-subtree-with-all-the-deepest-nodes) |
| [1123-lowest-common-ancestor-of-deepest-leaves](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1123-lowest-common-ancestor-of-deepest-leaves) |
| [1161-maximum-level-sum-of-a-binary-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1161-maximum-level-sum-of-a-binary-tree) |
## Depth-First Search
|  |
| ------- |
| [0543-diameter-of-binary-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0543-diameter-of-binary-tree) |
| [0865-smallest-subtree-with-all-the-deepest-nodes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0865-smallest-subtree-with-all-the-deepest-nodes) |
| [1123-lowest-common-ancestor-of-deepest-leaves](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1123-lowest-common-ancestor-of-deepest-leaves) |
| [1161-maximum-level-sum-of-a-binary-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1161-maximum-level-sum-of-a-binary-tree) |
## Breadth-First Search
|  |
| ------- |
| [0102-binary-tree-level-order-traversal](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0102-binary-tree-level-order-traversal) |
| [0865-smallest-subtree-with-all-the-deepest-nodes](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0865-smallest-subtree-with-all-the-deepest-nodes) |
| [1123-lowest-common-ancestor-of-deepest-leaves](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1123-lowest-common-ancestor-of-deepest-leaves) |
| [1161-maximum-level-sum-of-a-binary-tree](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1161-maximum-level-sum-of-a-binary-tree) |
## String
|  |
| ------- |
| [0712-minimum-ascii-delete-sum-for-two-strings](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0712-minimum-ascii-delete-sum-for-two-strings) |
## Stack
|  |
| ------- |
| [0085-maximal-rectangle](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0085-maximal-rectangle) |
## Matrix
|  |
| ------- |
| [0085-maximal-rectangle](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0085-maximal-rectangle) |
## Monotonic Stack
|  |
| ------- |
| [0085-maximal-rectangle](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/0085-maximal-rectangle) |
## Bit Manipulation
|  |
| ------- |
| [1356-sort-integers-by-the-number-of-1-bits](https://github.com/Pawar-Sudharshan/DSA-problems/tree/master/1356-sort-integers-by-the-number-of-1-bits) |
<!---LeetCode Topics End-->