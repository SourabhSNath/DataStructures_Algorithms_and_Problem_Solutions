package datastructures.linkedlist;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {

    private static class Node<T> {
        Node<T> next;
        T data;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    Node<T> first;
    int size = 0;

    //Empty Constructor
    public SinglyLinkedList() {
    }

    //Constructor with initial data
    public SinglyLinkedList(T data) {
        addFirst(data);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addFirst(T data) {
        if (isEmpty()) first = new Node<>(data, null);
        else {
            first = new Node<>(data, first);
        }
        size++;
    }

    public void addLast(T data) {
        if (isEmpty()) first = new Node<>(data, null);
        else {
            Node<T> traverse = first;

            while (traverse.next != null) {
                traverse = traverse.next;
            }
            traverse.next = new Node<>(data, null);
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List");

        else if (first.next == null) {

            T data = first.data;
            first = null;

            size--;
            return data;

        } else {

            T data = first.data;
            first = first.next;

            size--;
            return data;
        }
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");

        else if (first.next == null) {
            size--;

            T data = first.data;
            first = null;
            return data;

        } else {
            size--;

            Node<T> traverse = first;

            //Stops before the last node
            while (traverse.next.next != null) {
                traverse = traverse.next;
            }

            T data = traverse.next.data;

            //setting the reference to null, garbage collector collects the last node
            traverse.next = null;

            return data;
        }
    }

    public void reverseLinkedList() {

        Node<T> previous = null;
        Node<T> currentNode = first;

        while (currentNode != null) {
            Node<T> nextNode = currentNode.next;

            currentNode.next = previous;
            previous = currentNode;

            currentNode = nextNode;
        }

        first = previous;
    }

    public T peekFirst() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        return first.data;
    }

    public T peekLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");

        Node<T> traverse = first;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        return traverse.data;
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder().append("[");
        Node<T> traverse = first;


        while (traverse.next != null) {
            stringBuilder.append(traverse.data).append(", ");
            traverse = traverse.next;
        }
        return stringBuilder.append(traverse.data).append("]").toString();

    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> traverse = first;

            @Override
            public boolean hasNext() {
                return traverse.next != null;
            }

            @Override
            public T next() {
                T data = traverse.data;
                traverse = traverse.next;
                return data;
            }
        };
    }

}

class Demo {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);

        System.out.println(singlyLinkedList);
    }
}
