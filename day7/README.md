# Intersection of Two Linked Lists

Given the heads of two singly linked-lists `headA` and `headB`, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return `null`.

- The linked lists must retain their original structure after the function returns.
- The intersection is defined by reference, not value.

---

## Examples

**Example 1:**

Input:  
listA = [4,1,8,4,5]  
listB = [5,6,1,8,4,5]  
skipA = 2, skipB = 3  
Output: Intersected at '8'  
Explanation: Lists intersect at node with value 8.

**Example 2:**

Input:  
listA = [1,9,1,2,4]  
listB = [3,2,4]  
skipA = 3, skipB = 1  
Output: Intersected at '2'  
Explanation: Lists intersect at node with value 2.

**Example 3:**

Input:  
listA = [2,6,4]  
listB = [1,5]  
Output: No intersection  
Explanation: The lists do not intersect.

---

## Constraints

- 1 <= m, n <= 3 * 10^4
- 1 <= Node.val <= 10^5
- 0 <= skipA <= m
- 0 <= skipB <= n
- intersectVal is 0 if lists do not intersect
- intersectVal == listA[skipA] == listB[skipB] if lists intersect

---

## Approach

- Use two pointers starting at the heads of each list.
- Traverse each list with the pointers, switching heads when the end is reached.
- They will meet at the intersection node after at most two passes.

---

## Java Solution

class ListNode {
int val;
ListNode next;
ListNode(int x) {
val = x;
next = null;
}
}

class Solution {
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

public class Main {
public static void main(String[] args) {
// Example for intersecting lists (node value 8)
ListNode common = new ListNode(8);
common.next = new ListNode(4);
common.next.next = new ListNode(5);

text
    ListNode headA = new ListNode(4);
    headA.next = new ListNode(1);
    headA.next.next = common;

    ListNode headB = new ListNode(5);
    headB.next = new ListNode(6);
    headB.next.next = new ListNode(1);
    headB.next.next.next = common;

    Solution solution = new Solution();
    ListNode intersection = solution.getIntersectionNode(headA, headB);
    System.out.println(intersection != null ? "Intersected at '" + intersection.val + "'" : "No intersection");

    // Example for non-intersecting lists
    ListNode headA2 = new ListNode(2);
    headA2.next = new ListNode(6);
    headA2.next.next = new ListNode(4);

    ListNode headB2 = new ListNode(1);
    headB2.next = new ListNode(5);

    intersection = solution.getIntersectionNode(headA2, headB2);
    System.out.println(intersection != null ? "Intersected at '" + intersection.val + "'" : "No intersection");
}
}

text

---

## Dry Run

### Testcase 1

Input:  
listA = [4,1,8,4,5]  
listB = [5,6,1,8,4,5]  
SkipA = 2, SkipB = 3  

| Step | t1 position | t2 position | Comments                      |
|------|-------------|-------------|-------------------------------|
| 1    | 4           | 5           | Traverse both lists           |
| 2    | 1           | 6           |                               |
| 3    | 8           | 1           |                               |
| 4    | 4           | 8           |                               |
| 5    | 5           | 4           |                               |
| 6    | null        | 5           | t1 starts at headB            |
| 7    | 5           | null        | t2 starts at headA            |
| ...  | ...         | ...         | Eventually meet at node 8     |

**Output:** Intersected at '8'

---

### Testcase 2

Input:  
listA = [2,6,4], listB = [1,5]  

| Step | t1 position | t2 position | Comments                  |
|------|-------------|-------------|---------------------------|
| 1    | 2           | 1           | Traverse                  |
| 2    | 6           | 5           |                           |
| 3    | 4           | null        | t2 restarts at headA      |
| 4    | null        | 2           | t1 restarts at headB      |
| ...  | ...         | ...         | Both reach null, no meet  |

**Output**: No intersection

---

## Time Complexity

- **O(m+n)** for m = length of listA, n = length of listB

## Space Complexity

- **O(1)** (constant extra space)

---