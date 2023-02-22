package hashmap;

import java.util.HashMap;
import java.util.Map;

public class MyLRUCache {
    class ListNode {
        int key;
        int value;
        ListNode prev, next;

        public ListNode() {
        }

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, ListNode> cache;
    private int size;
    private int capacity;
    private ListNode head, tail;

    private void addToHead(ListNode node) {
        node.prev = head;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
    }


    private ListNode removeTail() {
        ListNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        cache = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node == null) {
            ListNode newNode = new ListNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                ListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

}
