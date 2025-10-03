package day5;

/**
 * Leetcode 160 - Intersection of Two Linked Lists
 * Problem: Given heads of two singly linked-lists, return the node at which they intersect
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    /**
     * Approach: Two Pointer Method
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        
        // If either list is empty, no intersection
        if(t1 == null || t2 == null) return null;
        
        // Traverse both lists
        while(t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
            
            // If they meet, return the intersection
            if(t1 == t2) return t1;
            
            // When reaching end of list A, redirect to head of B
            if(t1 == null) t1 = headB;
            
            // When reaching end of list B, redirect to head of A
            if(t2 == null) t2 = headA;
        }
        
        return t1;
    }
}

public class Main {
    
    // Helper method to create a linked list from array
    public static ListNode createList(int[] arr) {
        if(arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for(int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    // Helper method to create intersection
    public static ListNode createIntersection(ListNode headA, ListNode headB, int skipA, int skipB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        // Move to skipA position in list A
        for(int i = 0; i < skipA && tempA != null; i++) {
            tempA = tempA.next;
        }
        
        // Move to skipB position in list B
        for(int i = 0; i < skipB && tempB != null; i++) {
            if(i < skipB - 1) {
                tempB = tempB.next;
            }
        }
        
        // Connect list B to intersection point
        if(tempB != null) {
            tempB.next = tempA;
        }
        
        return tempA;
    }
    
    // Helper method to print list
    public static void printList(ListNode head) {
        ListNode temp = head;
        System.out.print("[");
        while(temp != null) {
            System.out.print(temp.val);
            if(temp.next != null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        System.out.println("=== Leetcode 160: Intersection of Two Linked Lists ===");
        System.out.println();
        
        // Test Case 1: Lists intersect at node with value 8
        System.out.println("Test Case 1: Lists intersect at value 8");
        System.out.println("Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]");
        System.out.println("       skipA = 2, skipB = 3");
        
        ListNode headA1 = createList(new int[]{4, 1, 8, 4, 5});
        ListNode headB1 = createList(new int[]{5, 6, 1});
        
        // Create intersection
        ListNode tempA1 = headA1;
        for(int i = 0; i < 2; i++) tempA1 = tempA1.next; // Point to node 8
        
        ListNode tempB1 = headB1;
        while(tempB1.next != null) tempB1 = tempB1.next; // Go to end of B
        tempB1.next = tempA1; // Connect to intersection
        
        ListNode result1 = solution.getIntersectionNode(headA1, headB1);
        System.out.println("Output: Intersected at '" + (result1 != null ? result1.val : "null") + "'");
        System.out.println();
        
        // Test Case 2: Lists intersect at node with value 2
        System.out.println("Test Case 2: Lists intersect at value 2");
        System.out.println("Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4]");
        System.out.println("       skipA = 3, skipB = 1");
        
        ListNode headA2 = createList(new int[]{1, 9, 1, 2, 4});
        ListNode headB2 = createList(new int[]{3});
        
        // Create intersection at node 2
        ListNode tempA2 = headA2;
        for(int i = 0; i < 3; i++) tempA2 = tempA2.next; // Point to node 2
        
        headB2.next = tempA2; // Connect B to intersection
        
        ListNode result2 = solution.getIntersectionNode(headA2, headB2);
        System.out.println("Output: Intersected at '" + (result2 != null ? result2.val : "null") + "'");
        System.out.println();
        
        // Test Case 3: No intersection
        System.out.println("Test Case 3: No intersection");
        System.out.println("Input: intersectVal = 0, listA = [2,6,4], listB = [1,5]");
        System.out.println("       skipA = 3, skipB = 2");
        
        ListNode headA3 = createList(new int[]{2, 6, 4});
        ListNode headB3 = createList(new int[]{1, 5});
        
        ListNode result3 = solution.getIntersectionNode(headA3, headB3);
        System.out.println("Output: " + (result3 != null ? "Intersected at '" + result3.val + "'" : "No intersection"));
        System.out.println();
        
        // Test Case 4: One list is empty
        System.out.println("Test Case 4: One list is empty");
        System.out.println("Input: listA = [1,2,3], listB = null");
        
        ListNode headA4 = createList(new int[]{1, 2, 3});
        ListNode headB4 = null;
        
        ListNode result4 = solution.getIntersectionNode(headA4, headB4);
        System.out.println("Output: " + (result4 != null ? "Intersected at '" + result4.val + "'" : "No intersection"));
        System.out.println();
        
        // Test Case 5: Same starting node
        System.out.println("Test Case 5: Lists are identical (intersect at head)");
        System.out.println("Input: listA = [1,2,3], listB = [1,2,3] (same list)");
        
        ListNode headA5 = createList(new int[]{1, 2, 3});
        ListNode headB5 = headA5; // Both point to same list
        
        ListNode result5 = solution.getIntersectionNode(headA5, headB5);
        System.out.println("Output: Intersected at '" + (result5 != null ? result5.val : "null") + "'");
        System.out.println();
        
        // Test Case 6: Different lengths, intersection at end
        System.out.println("Test Case 6: Different lengths, intersection at end");
        System.out.println("Input: listA = [1,2,3,4], listB = [9,4] (intersect at 4)");
        
        ListNode headA6 = createList(new int[]{1, 2, 3, 4});
        ListNode headB6 = createList(new int[]{9});
        
        // Find last node of A
        ListNode tempA6 = headA6;
        while(tempA6.next != null) tempA6 = tempA6.next;
        
        headB6.next = tempA6; // Connect to last node
        
        ListNode result6 = solution.getIntersectionNode(headA6, headB6);
        System.out.println("Output: Intersected at '" + (result6 != null ? result6.val : "null") + "'");
        System.out.println();
        
        System.out.println("=== All Test Cases Completed ===");
    }
}