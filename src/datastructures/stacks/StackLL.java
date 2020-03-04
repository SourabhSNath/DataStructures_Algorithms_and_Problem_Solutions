package datastructures.stacks;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * A stack using Linked List
 * Using the java.util.LinkedList here, which is a doubly linked list internally
 *
 * @param <T>
 */

public class StackLL<T> implements Iterable<T> {

    LinkedList<T> list = new LinkedList<>();

    //Create an empty Stack
    public StackLL() {
    }

    //To create a stack with the first element
    public StackLL(T firstElement) {
        push(firstElement);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void push(T element) {
        list.addLast(element);
    }

    public T pop() {

        if (isEmpty()) throw new EmptyStackException();

        T data = list.getLast();
        list.removeLast();
        return data;
    }

    public T peek() {
        if (isEmpty()) throw new EmptyStackException();

        return list.peekLast();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("[");
        for (int i = 0; i < list.size() - 1; i++) {
            stringBuilder.append(list.get(i)).append(", ");
        }
        return stringBuilder.append(list.getLast()).append("]").toString();
    }


    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
