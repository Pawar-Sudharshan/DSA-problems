class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases
        if (head == null || head.next == null || k == 0) return head;

        // 1) Find length and tail
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2) Normalize k
        k = k % length;
        if (k == 0) return head;

        // 3) Make it circular
        tail.next = head;

        // 4) New tail is (length - k - 1) steps from head
        int stepsToNewTail = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5) New head is next of newTail, then break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
