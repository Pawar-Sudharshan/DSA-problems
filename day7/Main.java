package day7;

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
        // Creating sample intersecting linked lists:
        ListNode common = new ListNode(8);
        common.next = new ListNode(10);

        ListNode headA = new ListNode(3);
        headA.next = new ListNode(7);
        headA.next.next = common;

        ListNode headB = new ListNode(99);
        headB.next = common;

        Solution solution = new Solution();
        ListNode intersection = solution.getIntersectionNode(headA, headB);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection found.");
        }
    }
}

