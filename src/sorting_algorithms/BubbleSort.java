package sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {

        /*
         * Static Array
         */
        int[] ar = {1, 5, 6, 2, 4, 1, 3, 9};

        // Bubble sort
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length - 1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(ar));

        /*
         * LinkedList
         */
        Node list = new Node(5);
        Node dummy = list;
        int count = 8;
        while (count != 0) {
            dummy.next = new Node(new Random().nextInt(9) + 1);
            dummy = dummy.next;
            count--;
        }
        displayLinkedList(list);

        // Bubble Sort
        Node current = list;
        while (current != null) {
            Node second = current.next;

            while (second != null) {
                if (current.val > second.val) {
                    int temp = current.val;
                    current.val = second.val;
                    second.val = temp;
                }
                second = second.next;
            }

            current = current.next;
        }
        displayLinkedList(list);

    }

    // Node to form a SinglyLinkedList
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    // Display Method
    private static void displayLinkedList(Node list) {
        Node dummy = list;
        while (dummy.next != null) {
            System.out.print(dummy.val + "->");
            dummy = dummy.next;
        }
        System.out.println(dummy.val);
    }

}
