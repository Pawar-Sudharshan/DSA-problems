/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();
        while(temp != null && !set.contains(temp)){
            set.add(temp);
            temp = temp.next;
        }
        if(set.contains(temp)) return temp;
        return null;
    }
}