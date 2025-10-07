text
# Palindrome Linked List

Given the head of a singly linked list, return `true` if it is a palindrome or `false` otherwise.

- The number sequence of nodes should be the same forward and backward.

---

## Examples

**Example 1:**

Input:  
head = [1,2,2,1]  
Output: `true`  
Explanation: The list reads the same forward and backward.

**Example 2:**

Input:  
head = [1,2]  
Output: `false`  
Explanation: The list is not a palindrome.

---

## Constraints

- The number of nodes in the list is in the range \([1, 10^5]\)
- \(0 \leq \text{Node.val} \leq 9\)

---

## Approach

- Traverse the list and build its string representation.
- Check if the string is the same as its reverse.
- (Follow-up: Can be done in \(O(1)\) space by reversing half the list.)

---

## Java Solution

class ListNode {
int val;
ListNode next;
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
public boolean isPalindrome(ListNode head) {
StringBuffer str = new StringBuffer();
ListNode temp = head;
while(temp != null) {
str.append(temp.val);
temp = temp.next;
}
String original = str.toString();
return original.equals(str.reverse().toString());
}
}

public class Main {
public static void main(String[] args) {
// Example 1:
ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
Solution sol = new Solution();
boolean result1 = sol.isPalindrome(head1);
System.out.println("Output for head = : " + result1); // true

text
    // Example 2:[1]
    ListNode head2 = new ListNode(1, new ListNode(2));
    boolean result2 = sol.isPalindrome(head2);
    System.out.println("Output for head =  : " + result2); // false[1]
}
}

text

---

## Dry Run

### Testcase 1

Input:  
head = [1,2,2,1]

| Step | temp.val | str      | Comments    |
|------|----------|----------|------------|
| 1    |    1     | "1"      | Add 1      |
| 2    |    2     | "12"     | Add 2      |
| 3    |    2     | "122"    | Add 2      |
| 4    |    1     | "1221"   | Add 1      |

Check: "1221" equals "1221" (reversed) → **true**

---

### Testcase 2

Input:  
head = [1,2]

| Step | temp.val | str   | Comments  |
|------|----------|-------|-----------|
| 1    |    1     | "1"   | Add 1     |
| 2    |    2     | "12"  | Add 2     |

Check: "12" equals "21" (reversed)? → **false**

---

## Time Complexity

- **O(n)** — Traverse list once

## Space Complexity

- **O(n)** — To store string representation

- **Follow-up:** Achievable in **O(1)** space by reversing half the list in place and comparing