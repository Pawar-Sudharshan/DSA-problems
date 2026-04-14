class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode head : lists) {
            while (head != null) {
                pq.offer(head.val);
                head = head.next;
            }
        }

        if (pq.isEmpty()) return null;

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {
            tail.next = new ListNode(pq.poll());
            tail = tail.next;
        }

        return dummy.next;
    }
}