/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Push all nodes onto stack
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;
        int n = 0;
        while (curr != null) {
            st.push(curr);
            curr = curr.next;
            n++;
        }

        curr = head;
        // We will do n/2 re-links: each time insert one node from the end
        for (int i = 0; i < n / 2; i++) {
            ListNode tail = st.pop();
            // Insert tail after curr
            tail.next = curr.next;
            curr.next = tail;
            // Move curr to the node after the inserted tail
            curr = tail.next;
        }

        // Important: terminate the list to avoid cycle
        if (curr != null) curr.next = null;
    }
}