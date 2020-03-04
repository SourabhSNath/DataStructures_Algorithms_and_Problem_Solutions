package datastructures.dynamicarray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int length = 0; //user thinks this is the actual length of the array, because it may have more space
    private int capacity = 0; //actual capacity of the array

    public DynamicArray() {
        this(16); //initialize array to be size 16
    }


    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity]; //instantiate it like this, generics cannot be instantiated
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public T get(int index) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        } else {
            return arr[index];
        }
    }

    public void set(int index, T element) {
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = null;
        }
        length = 0;
    }

    /**
     * Resize the array
     * capacity
     */
    public void add(T element) {
        //resize array if length+1 >= capacity
        if (length + 1 >= capacity) {
            if (capacity == 0) capacity = 1;
            else capacity *= 2; //Double the size;

            T[] new_arr = (T[]) new Object[capacity];
            System.arraycopy(arr, 0, new_arr, 0, arr.length); //copy to new array
            arr = new_arr; //set arr as new array with the new size, empty indexes are nulls
        }

        arr[length++] = element;
    }

    public T removeAt(int index) {
        if (index > length || index < 0) throw new IndexOutOfBoundsException();
        T data = arr[index];
        T[] new_arr = (T[]) new Object[length - 1];

        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) {
                j--;
            } else {
                new_arr[j] = arr[i];
            }
        }

        arr = new_arr;
        capacity = --length; //reset capacity

        return data;
    }

    public boolean remove(T element) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element) {
        for (int i = 0; i < length; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T element) {
        if (indexOf(element) != -1) {
            return true;
        }
        return false;
    }


    /**
     * Implementing this interface allows an object to be the target of the "for-each loop" statement. See For-each Loop
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return arr[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (length == 0) return "[]";
        else {
            StringBuilder stringBuilder = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++) {
                stringBuilder.append(arr[i]).append(", ");
            }
            return stringBuilder.append(arr[length - 1]).append("]").toString();
        }
    }
}
