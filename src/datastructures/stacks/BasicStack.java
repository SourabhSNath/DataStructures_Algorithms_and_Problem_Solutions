package datastructures.stacks;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Turned a basic stack into this
 *
 * @param <T>
 */

@SuppressWarnings({"unchecked", "unused"})
public class BasicStack<T> implements Iterable<T> {
    private int maxSize;

    private T[] stackArray;
    private int top = -1;

    public BasicStack() {
        this(16);
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public BasicStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = (T[]) new Object[maxSize];
    }

    public void push(T element) throws ArrayIndexOutOfBoundsException {
        if (top == maxSize - 1) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            top++;
            stackArray[top] = element;
        }
    }

    public T pop() {
        // if (top < 0) throw new IndexOutOfBoundsException(top);

        return stackArray[--top];
    }

    public int indexOf(T element) {
        for (int i = 0; i < maxSize; i++) {
            if (stackArray[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    public T peak() {
        if (isEmpty()) throw new EmptyStackException();
        return stackArray[top];
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < top; i++) {
            stringBuilder.append(stackArray[i]).append(", ");
        }
        stringBuilder.append(stackArray[top]).append("]"); //append the last element after comma

        return stringBuilder.toString();
    }


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < top + 1;
            }

            @Override
            public T next() {
                return stackArray[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
