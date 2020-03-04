package solutions.java.leetcode;


import solutions.java.leetcode.helperclasses.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        displayInput(l1, l2);

        ListNode l3 = new Solution().addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }

    /**
     * ********************
     * Solution
     * ********************
     */
    private static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode result_Node = new ListNode(0);
            ListNode result_Dummy = result_Node;


            int carry = 0;
            while (l1 != null || l2 != null) {

                result_Dummy.next = new ListNode(0);
                result_Dummy = result_Dummy.next;
                int sum = 0;

                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                sum += carry;

                result_Dummy.val = sum % 10;
                carry = sum / 10;

                if (carry != 0) {
                    result_Dummy.next = new ListNode(carry);
                }
            }

            return result_Node.next;
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
