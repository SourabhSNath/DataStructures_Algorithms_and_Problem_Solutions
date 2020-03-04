package datastructures.queues;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueLL<T> implements Iterable<T> {

    LinkedList<T> list = new LinkedList<>();


    public QueueLL() {
    }

    public QueueLL(T data) {
        offer(data);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    //See the first item in the queue
    public T peek() {
        return list.peekFirst();
    }

    //Dequeue
    public T poll() {

        if (isEmpty()) throw new RuntimeException("Empty Queue");
        return list.removeFirst();
    }

    //Enqueue, java.util.LinkedList is Doubly Linked List, adding to the end is O(1)
    public void offer(T data) {
        list.addLast(data);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
