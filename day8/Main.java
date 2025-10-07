package day8;

/**
 * Definition for singly-linked list node.
 */
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
        // Example 1: Palindrome linked list: 1 -> 2 -> 2 -> 1
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

        Solution sol = new Solution();
        boolean result1 = sol.isPalindrome(head1);
        System.out.println("Is palindrome (Test 1)? " + result1);

        // Example 2: Non-palindrome linked list: 1 -> 2
        ListNode head2 = new ListNode(1, new ListNode(2));

        boolean result2 = sol.isPalindrome(head2);
        System.out.println("Is palindrome (Test 2)? " + result2);
    }
}

