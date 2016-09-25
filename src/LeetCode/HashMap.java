package LeetCode;

import java.util.Arrays;

/**
 * Created by yuliu on 9/21/16.
 * A hashtabke implementation of map, generic type is provided
 *
 * Supported operations
 * size()
 * isEmpty()
 * clear()
 * put(K key, V value)
 * get(K key)
 * containsKey(K key)
 * containsValue(V value)
 * remove(K key)
 */
public class HashMap<K, V> {
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey(){
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    // static final variables are global constants
    public static final int DEFAULT_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size; // how many k-v pairs are actually stored in the Important.HashMap
    private float loadFactor;//determin when to rehash;

    public HashMap(){
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("cap cannot be <= 0");
        }
        this.array = (Node<K, V>[])(new Node[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    //non-negative
    private int hash(K key) {
        //1.null key
        if (key == null) {
            return 0;
        }
        return key.hashCode() & 0X7FFFFFFF;//01111111 11111111 11111111 11111111强制正数
    }

    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
        if (v1 == null && v2 == null) {
            return true;
        }
        if (v1 == null || v2 == null) {
            return false;
        }
        return v1.equals(v2);
    }

    //O(n),traverse the whole array and traverse each of the linked list in the array
    public boolean cotainsValue(V value) {
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> node : array) {
            while(node != null) {
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    private boolean equalsKey(K k1, K k2) {
        if (k1 == null || k2 == null) {
            return true;
        }
        if (k1 == null && k2 == null) {
            return false;
        }
        return k1.equals(k2);
    }

    public boolean containsKey(K key) {
        //get index of the key
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while(node != null) {
            //check if the key equals()
            //key, node.key() all possible to be null
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //The get(Object key) method is used to return the value to which the specified key is mapped,
    // or null if this map contains no mapping for the key
    public V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while(node != null) {
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }


    //The method call returns the previous value associated with key, or null if there was no mapping for key.
    public V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> cur = head;
        while(cur != null) {
            if (equalsKey(cur.key, key)) {
                V result = cur.value;
                cur.value = value;
                return result;
            }
            cur = cur.next;
        }
        Node<K, V> newNode = new Node(key, value);
        newNode.next = head;//从头上插进去 我们不care顺序 随便 所以从头部插入简单就从头部插入
        array[index] = newNode;
        size++;
        if(needRehashing()) {
            rehasing();
        }
        return null;
    }

    private boolean needRehashing() {
        float ratio = (size  + 0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void rehasing() {
        int newCapacity = array.length * 2;
        Node<K, V>[] newArray = new Node[newCapacity];
        Node<K, V>[] oldArray;
        oldArray = array;
        for (Node<K, V> node : oldArray) {
            put(node.key, node.value);
        }
    }

    //The method call returns the previous value associated with key, or null if there was no mapping for key.
    public V remove(K key) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> cur = head;
        while(cur != null) {
            Node<K, V> next = cur.next;
            if (equalsKey(cur.key, key)) {
                V result = cur.value;
                head.next = next;
                return result;
            }
            head = cur;
            cur = next;
            size--;
        }
        return null;
        //get index
        //delete operation on the linked list
    }


}
