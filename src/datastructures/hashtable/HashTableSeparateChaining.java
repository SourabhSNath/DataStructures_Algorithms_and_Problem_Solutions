package datastructures.hashtable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Incomplete
 */

class Entry<K, V> {
    int hash;
    K key;
    V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.hash = key.hashCode(); //generate hash value using key
    }

    // We are not overriding the Object equals method
    // No casting is required with this method.

    public boolean equals(Entry<K, V> other) {
        if (hash != other.hash) return false;

        return key.equals(other.key); //If it is equal, check the keys directly
    }

    @Override
    public String toString() {
        return key + "=>" + value;
    }

    public int getHash() {
        return hash;
    }
}

@SuppressWarnings("unchecked")
public class HashTableSeparateChaining<K, V> implements Iterable<K> {

    /**
     * An instance of HashMap has two parameters that affect its performance: initial capacity and load factor.
     * The capacity is the number of buckets in the hash table,
     * and the initial capacity is simply the capacity at the time the hash table is created.
     * The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.
     * When the number of entries in the hash table exceeds the product of the load factor and the current capacity,
     * the hash table is rehashed (that is, internal data structures are rebuilt) so that the hash table
     * has approximately twice the number of buckets.
     * <p>
     * As a general rule, the default load factor (.75) offers a good tradeoff between time and space costs.
     * Higher values decrease the space overhead but increase the lookup cost (reflected in most of the operations of the HashMap class,
     * including get and put). The expected number of entries in the map and its load factor should be taken into account
     * when setting its initial capacity, so as to minimize the number of rehash operations.
     * If the initial capacity is greater than the maximum number of entries divided by the load factor,
     * no rehash operations will ever occur.
     */

    private static final int DEFAULT_CAPACITY = 3;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;


    /**
     * maxLoadFactor: resize the table when it goes above this
     * capacity is the table size
     * threshold is capacity * maxLoadFactor, if it is above threshold then resize
     * size is no. of items in the table
     */
    private float maxLoadFactor;
    private int capacity, threshold, size = 0;

    /**
     * The table, an array of LinkedList
     */
    private LinkedList<Entry<K, V>>[] table;


    //default constructor
    public HashTableSeparateChaining() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTableSeparateChaining(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity below 0");

        this.capacity = Math.max(DEFAULT_CAPACITY, capacity); //in case the capacity provided is below Default capacity
        this.maxLoadFactor = DEFAULT_LOAD_FACTOR;
        threshold = (int) (capacity * maxLoadFactor);

        table = new LinkedList[this.capacity];
    }

    public HashTableSeparateChaining(int capacity, float maxLoadFactor) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity below 0");
        if (maxLoadFactor <= 0 || Float.isNaN(maxLoadFactor) || Float.isInfinite(maxLoadFactor))
            throw new IllegalArgumentException("Illegal Max Load Factor");

        this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.maxLoadFactor = maxLoadFactor;
        threshold = (int) (capacity * maxLoadFactor);

        table = new LinkedList[this.capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Normalize the Hash value, so that it can be used as an Index
     * The hash value can be anywhere from Integer.MIN_VALUE to Integer.MAX_VALUE;
     * <p>
     * Here it is put in the domain of 0 to capacity
     * <p>
     * & is Bitwise operator here
     * 110 & 100 = 100, only the common 1 is in the output
     */

    private int normalizedHashValue(int keyHash) {
        return (keyHash & 0x7FFFFFFF) % capacity;
    }

    public void clearTable() {
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean containsKey(K key) {
        int bucketIndex = normalizedHashValue(key.hashCode());
        return bucketSeekEntry(key, bucketIndex) == null;
    }

    public V put(K key, V value) {
        if (key == null) throw new IllegalArgumentException("Null Key");
        else {
            Entry<K, V> newEntry = new Entry<>(key, value); //create the entry object

            int bucketIndex = normalizedHashValue(key.hashCode());

            return bucketInsertEntry(bucketIndex, newEntry); //pass the index and the entry object to be inserted
        }
    }

    public V get(K key) {
        if (key == null) throw new IllegalArgumentException("Null Key");
        int bucketIndex = normalizedHashValue(key.hashCode());

        Entry<K, V> entry = bucketSeekEntry(key, bucketIndex); //check for the entry

        if (entry != null) {
            return entry.value;
        } else {
            return null;
        }
    }

    private Entry<K, V> bucketSeekEntry(K key, int bucketIndex) {
        return null;
    }

    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("Null Key");

        int bucketIndex = normalizedHashValue(key.hashCode());

        Entry<K, V> entry = bucketSeekEntry(key, bucketIndex);

        if (entry != null) {

            LinkedList<Entry<K, V>> linkedList = table[bucketIndex];
            linkedList.remove(bucketIndex);

            --size;
            return entry.value;
        }
        return null;
    }


    // Inserts an entry in a given bucket only if the entry does not already
    // exist in the given bucket, but if it does then update the entry value
    private V bucketInsertEntry(int bucketIndex, Entry<K, V> newEntry) {

        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket == null) {
            table[bucketIndex] = bucket = new LinkedList<>(); //lazily allocating a new LinkedList
        }

        Entry<K, V> existentEntry = bucketSeekEntry(newEntry.key, bucketIndex);
        if (existentEntry == null) {
            bucket.add(newEntry);
            if (++size > threshold) resizeTable();

            return null; /*Null if there was no previous value*/
        } else {
            V oldValue = existentEntry.value;
            existentEntry.value = newEntry.value;
            return oldValue;
        }

    }

    private void resizeTable() {

    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }

}
