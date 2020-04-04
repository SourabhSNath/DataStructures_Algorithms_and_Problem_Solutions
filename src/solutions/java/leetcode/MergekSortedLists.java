package solutions.java.leetcode;

import solutions.java.leetcode.helperclasses.ListNode;

public class MergekSortedLists {

    public static void main(String[] args) {

        ListNode[] lists = getInputs();

        ListNode output = new Solution().mergeKSortedLists(lists);

        System.out.print("Output: ");
        while (output.next != null) {
            System.out.print(output.val + " -> ");
            output = output.next;
        }
        System.out.println(output.val);
    }

    /*
     ***********************
     * Solution
     ***********************
     */

    private static class Solution {
        public ListNode mergeKSortedLists(ListNode[] lists) {

            ListNode new_node = new ListNode(0);
            ListNode dummy = new_node;

            for (int i = 0; i < lists.length - 1; i++) {
                ListNode l1 = lists[i];
                ListNode l2 = lists[i + 1];

                while (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        dummy.next = l1;
                        l1 = l1.next;
                    } else {
                        dummy.next = l2;
                        l2 = l2.next;
                    }

                    dummy = dummy.next;
                }

                if (l1 != null) dummy.next = l1;
                if (l2 != null) dummy.next = l2;
            }

            return new_node;
        }
    }


    // Inputs
    private static ListNode[] getInputs() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        for (ListNode listNode : lists) {
            System.out.print("Input: ");
            while (listNode.next != null) {
                System.out.print(listNode.val + " -> ");
                listNode = listNode.next;
            }
            System.out.println(listNode.val);
        }

        System.out.println();

        return lists;
    }
}
