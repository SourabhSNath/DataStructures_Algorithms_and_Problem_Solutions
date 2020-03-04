package solutions.java.leetcode;

import solutions.java.leetcode.helperclasses.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example: Input: 1->2->4, 1->3->4 Output: 1->1->2->3->4->4
 */

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        final ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        final ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);

        displayInput(l1, l2);

        ListNode l3 = Solution.mergeTwoLists(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }

    /**********************
     * Solution
     **********************
     */
    private static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode new_node = new ListNode(0);
            ListNode traverse = new_node;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    traverse.next = l1; // set traverse.next = l1 node
                    l1 = l1.next;
                } else {
                    traverse.next = l2; // traverse.next = l2 node
                    l2 = l2.next;
                }

                traverse = traverse.next; // move traverse to traverse.next
            }

            if (l1 != null)
                traverse.next = l1;
            if (l2 != null)
                traverse.next = l2;

            return new_node.next;
        }

    }

    static void displayInput(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        System.out.print("Input1: ");
        while (temp1.next != null) {
            System.out.print(temp1.val + " -> ");
            temp1 = temp1.next;
        }
        System.out.println(temp1.val);

        System.out.print("Input2: ");
        while (temp2.next != null) {
            System.out.print(temp2.val + " -> ");
            temp2 = temp2.next;
        }
        System.out.println(temp2.val);

    }
}
