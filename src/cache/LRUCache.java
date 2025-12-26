package cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import model.Node;
import util.DoublyLinkedList;

public class LRUCache implements Cache {

    private int capacity;
    private Map<Integer, Node> map;
    private DoublyLinkedList list;
    private ReentrantLock lock;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList();
        this.lock = new ReentrantLock();
    }

    @Override
    public int get(int key) {
        lock.lock();
        try {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                Node node = map.get(key);
                list.deleteNode(node);
                list.addAfterHead(node);
                return node.value;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void put(int key, int value) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;

                list.deleteNode(node);
                list.addAfterHead(node);
            }
            else {
                if (map.size() == capacity) {
                    Node lru = list.removeLast();
                    map.remove(lru.key);
                }

                Node node = new Node(key, value);
                map.put(key, node);
                list.addAfterHead(node);
            }
        } finally {
            lock.unlock();
        }
    }
}
