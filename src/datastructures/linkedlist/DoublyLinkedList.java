package datastructures.linkedlist;

import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> previous;

        Node(T data, Node<T> next, Node<T> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void addFirst(T data) {
        if (first == null) first = last = new Node<>(data, null, null);
        else {

            first.previous = new Node<>(data, first, null);
            first = first.previous;
        }
        size++;
    }

    public void addLast(T data) {
        if (first == null) first = last = new Node<>(data, null, null);
        else {

            last.next = new Node<>(data, null, last);
            last = last.next;
        }
        size++;
    }

    public void addAt(int index, T data) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();

        /*
         * if simply reduces the time, if the index < middle then traverse from first,
         * else do it from last
         */
        if (index < size() / 2) {

            Node<T> traverse = first;
            for (int i = 0; i < index; i++) {
                traverse = traverse.next;
            }

            Node<T> previousNode = traverse.previous;

            //Null pointer exception if Previous = null
            if (previousNode != null) {

                size++;
                previousNode.next = new Node<>(data, traverse, previousNode);
            } else {

                addFirst(data);
            }

        } else {

            Node<T> traverseFromLast = last;

            for (int i = size - 1; i > index; i--) {
                traverseFromLast = traverseFromLast.previous;
            }

            Node<T> nextNode = traverseFromLast.previous;
            nextNode.next = new Node<>(data, traverseFromLast, nextNode);
            size++;
        }

    }

    public T removeFirst() {

        if (isEmpty()) throw new RuntimeException("Empty List");

        T data = first.data;
        first = first.next; //could be set to null if first.next = null

        if (first.next == null) last = null;
        else first.previous = null;

        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) throw new RuntimeException("Empty List");
        else if (last.previous == null) {
            T data = last.data;
            first = last = null;

            size--;
            return data;
        } else {

            T data = last.data;
            last.previous.next = null;
            last = last.previous;

            size--;
            return data;
        }
    }

    public T removeAt(int index) {
        if (isEmpty()) throw new RuntimeException("Empty List");
        if (index < 0 || index > size() - 1) throw new IndexOutOfBoundsException();

        if (index == 0) return removeFirst();
        else if (index == size() - 1) return removeLast();
        else {

            if (index < (size() - 1) / 2) {
                Node<T> traverse = first;

                for (int i = 0; i < index; i++) {
                    traverse = traverse.next;
                }

                return remove(traverse);

            } else {

                Node<T> traverse = last;
                for (int i = size() - 1; i > index; i--) {
                    traverse = traverse.previous;
                }

                return remove(traverse);

            }
        }
    }

    private T remove(Node<T> traverse) {

        T data = traverse.data;

        traverse.previous.next = traverse.next;
        traverse.next.previous = traverse.previous;

        traverse = traverse.next = traverse.previous = null;

        size--;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("[");

        if (first != null) {
            Node<T> traverse = first;
            while (traverse.next != null) {
                stringBuilder.append(traverse.data).append(", ");
                traverse = traverse.next;
            }

            return stringBuilder.append(traverse.data).append("]").toString();
        } else
            return stringBuilder.append("]").toString();
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

//Usage
class DoublyLinkedListUser {

    public static void main(String[] args) {

        DoublyLinkedList<Float> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFirst(1f);
        doublyLinkedList.addLast(2f);
        doublyLinkedList.addLast(3.69f);
        doublyLinkedList.addAt(0, 1.5f);

        System.out.println(doublyLinkedList.removeAt(1));
        System.out.println(doublyLinkedList);
    }
}
