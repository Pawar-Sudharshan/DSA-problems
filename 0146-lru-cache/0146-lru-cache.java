import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node node) {
        Node first = head.next;

        head.next = node;
        node.prev = head;

        node.next = first;
        first.prev = node;
    }

    void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    Node removeLast() {
        if (tail.prev == head) {
            return null;
        }

        Node last = tail.prev;
        remove(last);
        return last;
    }
}

class LRUCache {
    private final DoublyLinkedList dll;
    private final Map<Integer, Node> map;
    private final int cap;

    public LRUCache(int capacity) {
        dll = new DoublyLinkedList();
        map = new HashMap<>();
        cap = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);

        if (node == null) {
            return -1;
        }

        // Move accessed node to the most-recently-used position
        dll.remove(node);
        dll.addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            // Update existing node instead of creating a duplicate
            node.value = value;

            dll.remove(node);
            dll.addFirst(node);
            return;
        }

        Node newNode = new Node(key, value);

        map.put(key, newNode);
        dll.addFirst(newNode);

        if (map.size() > cap) {
            Node lruNode = dll.removeLast();
            map.remove(lruNode.key);
        }
    }
}