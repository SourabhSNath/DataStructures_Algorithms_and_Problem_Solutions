package datastructures.priorityqueue;

import java.util.*;

/**
 * Only allows elements that implements Comparable Interface
 *
 * @param <T>
 */
public class PrioQueue<T extends Comparable<T>> {

    // The number of elements currently inside the heap
    private int heapSize = 0;

    // The internal capacity of the heap
    private int heapCapacity = 0;

    // Used as the heap
    private List<T> heap = null;

    /*
     * This keeps track of the indices for a particular node value in the heap.
     * Having this map lets us have O(log(n)) removals and O(1) element check
     * at the cost of some additional space and minor overhead
     */
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    // Empty priority queue with a capacity of 1
    public PrioQueue() {
        this(1);
    }

    // Priority Queue with support for defining initial capacity
    public PrioQueue(int size) {
        heap = new ArrayList<>(size);
    }

    // For an array of elements
    public PrioQueue(T[] elements) {

        heapSize = heapCapacity = elements.length;
        heap = new ArrayList<>(heapCapacity);

        for (int i = 0; i < elements.length; i++) {
            addToMap(elements[i], i);
            heap.add(elements[i]);
        }

        // Heapify process
        // creates a heap
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
            sink(i);
        }
    }

    // For a Collection
    public PrioQueue(Collection<T> elements) {
        this(elements.size());
        for (T element : elements) {
            add(element);
        }
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    // Clears everything inside the heap
    public void clear() {
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i, null);
            heapSize = 0;
            map.clear();
        }
    }

    // Return the size
    public int size() {
        return heapSize;
    }

    // Returns the value of the lowest priority item
    public T peek() {
        if (isEmpty()) throw new NullPointerException();
        return heap.get(0);
    }

    // Remove the root of the heap, O(log(n))
    public T poll() {
        return removeAt(0);
    }

    // Check if element is present in the heap O(1) because of the map
    public boolean contains(T element) {
        if (element == null) return false;
        return map.containsKey(element);
    }

    public void add(T element) {
        if (element == null) throw new IllegalArgumentException();

        if (heapSize < heapCapacity) {
            heap.set(heapSize, element);
        } else {
            // else increase the capacity
            heap.add(element);
            heapCapacity++;
        }

        addToMap(element, heapSize);

        //Since the element is added to the end, switch and move upwards if required; i.e called swim
        swim(heapSize);
        heapSize++;
    }

    /*
     * Tests if the value of node i <= node j
     * This method assumes i and j are valid indices, O(1)
     */
    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);

        // compareTo works because <T extends Comparable>
        return node1.compareTo(node2) <= 0;
    }

    // Bottom up node swim, O(log(n))
    private void swim(int k) {
        // Grab the index of the next parent node
        int parent = (k - 1) / 2; // formula when moving upwards to get the current parent node to this node k

        while (k > 0 && less(k, parent)) {
            //Exchange K with parent
            swap(parent, k);
            k = parent;

            parent = (k - 1) / 2; // Grab the index of the next parent
        }
    }

    // Top down node sink, O(log(n))
    private void sink(int k) {

        while (true) {
            int left = 2 * k + 1; // Left  node
            int right = 2 * k + 2; // Right node
            int smallest = left; // Assume left is the smallest node of the two children

            // Find which is smaller left or right
            // If right is smaller set smallest to be right
            if (right < heapSize && less(right, left)) smallest = right;

            // Stop if we're outside the bounds of the tree
            // or stop early if we cannot sink k anymore
            if (left >= heapSize || less(k, smallest)) break;

            // Move down the tree following the smallest node
            swap(smallest, k);
            k = smallest;
        }

    }

    // Swap two nodes. Assumes i & j are valid, O(1)
    private void swap(int i, int j) {
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);

        mapSwap(elem_i, elem_j, i, j);
    }

    // Removes a particular element in the heap, O(log(n))
    public boolean remove(T element) {

        if (element == null) return false;

        // Linear removal via search, O(n)
        // for (int i = 0; i < heapSize; i++) {
        //   if (element.equals(heap.get(i))) {
        //     removeAt(i);
        //     return true;
        //   }
        // }

        // Logarithmic removal with map, O(log(n))
        Integer index = mapGet(element);
        if (index != null) removeAt(index);
        return index != null;
    }

    // Removes a node at particular index, O(log(n))
    private T removeAt(int i) {

        if (isEmpty()) return null;

        heapSize--;
        T removed_data = heap.get(i);
        swap(i, heapSize);

        // Obliterate the value
        heap.set(heapSize, null);
        mapRemove(removed_data, heapSize);

        // If the removed element was the last element
        if (i == heapSize) {
            return removed_data;
        }

        /*
         * Else do these,
         * since swap was performed we have to move the node up or down
         */
        T elem = heap.get(i);

        // Try sinking element
        sink(i);
        // If sinking did not work try swimming
        if (heap.get(i).equals(elem)) swim(i);

        return removed_data;
    }

    // Removes the index at a given value, O(log(n))
    private void mapRemove(T value, int index) {
        TreeSet<Integer> set = map.get(value);
        set.remove(index); // TreeSets take O(log(n)) removal time
        if (set.size() == 0) map.remove(value);
    }

    // Extract an index position for the given value
    // NOTE: If a value exists multiple times in the heap the highest
    // index is returned (this has arbitrarily been chosen)
    private Integer mapGet(T value) {
        TreeSet<Integer> set = map.get(value);
        if (set != null) return set.last();
        return null;
    }

    // Exchange the index of two nodes internally within the map
    private void mapSwap(T val1, T val2, int val1Index, int val2Index) {

        Set<Integer> set1 = map.get(val1);
        Set<Integer> set2 = map.get(val2);

        set1.remove(val1Index);
        set2.remove(val2Index);

        set1.add(val2Index);
        set2.add(val1Index);
    }

    private void addToMap(T value, int index) {

        TreeSet<Integer> set = map.get(value);

        // New value being inserted in map
        if (set == null) {

            set = new TreeSet<>();
            set.add(index);
            map.put(value, set);

            // Value already exists in map
        } else set.add(index);
    }

    @Override
    public String toString() {
        return heap.toString();
    }


}
