package Important;

import java.util.HashMap;

/**
 * Created by yuliu on 9/6/16.
 * Deisgn and implement a data structure for Least Recently Used cache.
 * It should support the following operations: get and set
 *
 * get(key) get the value of key if key exisis in the cache
 *
 * set(key, value) set or insert value if key is not present. When cache reach its capacity it
 * should invalidate the least recently used item before inserting a new one
 *
 * 复习cache定义
 * accessing large amounts of data is deemed too slow, a common speed up technique is to keep a
 * small amount of the data in a more accessible location know as a cache.
 * so that data is then stored in the cache so that next time you need it you can access it
 * much more quickly.
 *
 * 1.The key to solve this problem is using a double linked list which enables us to
 * quickly move nodes
 * 2.The LRU cache is a hash table of keys and double linked nodes. The hashtable makes the time
 * of get() to be O(1). The list of double linked nodes make the nodes adding/removal operations
 * O(1)
 */
public class LRUCache {
    static class Node{
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    //定义LRU cache这个类
    HashMap<Integer, Node> map;//map存的是key 和node
    int capicity;
    int count;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capicity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);//这个其实是dummy head
        tail = new Node(0, 0);//这个是dummy tail
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    private void deleteNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {//加在head的后面
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            int result = node.val;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.val = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capicity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }


}
