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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (true) {
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;

            // Find index of list whose current node has minimum value
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < minVal) {
                    minVal = lists[i].val;
                    minIndex = i;
                }
            }

            // All lists exhausted
            if (minIndex == -1) break;

            // Attach that node and move its pointer
            tail.next = lists[minIndex];
            tail = tail.next;
            lists[minIndex] = lists[minIndex].next;
        }

        return dummy.next;
    }
}