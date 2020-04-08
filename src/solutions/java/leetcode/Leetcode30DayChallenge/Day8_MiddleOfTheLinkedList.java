package solutions.java.leetcode.Leetcode30DayChallenge;

import solutions.java.leetcode.helperclasses.ListNode;

public class Day8_MiddleOfTheLinkedList {
    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode resultNode = Solution.middleNode(listNode);
        StringBuilder stringBuilder = new StringBuilder();
        while (resultNode.next != null) {
            stringBuilder.append(resultNode.val).append("->");
            resultNode = resultNode.next;
        }
        stringBuilder.append(resultNode.val);

        System.out.println(stringBuilder.toString());
    }

    private static class Solution {
        private static ListNode middleNode(ListNode head) {

            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow;

            // ListNode temp = head;

            // double count = 0;
            // while (temp.next != null) {
            // count++;
            // temp = temp.next;
            // }

            // ListNode newNode = new ListNode(0);
            // for (int i = 0; i <= count; i++) {

            // if (i == (int) Math.ceil(count / 2)) {
            // newNode = head;
            // }

            // head = head.next;
            // }

            // return newNode;
        }
    }
}
