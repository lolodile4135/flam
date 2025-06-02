import java.util.HashMap;

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();

        // Dummy head and tail to avoid null checks
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        remove(node);
        insertToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }

        if (cache.size() == capacity) {
            // Remove LRU from list and map
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        insertToFront(newNode);
        cache.put(key, newNode);
    }

    // Helper to remove a node from list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper to insert a node right after head
    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

  public class Main {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); 
        lru.put(3, 3);                  
        System.out.println(lru.get(2)); 
        lru.put(4, 4);                  
        System.out.println(lru.get(1)); 
        System.out.println(lru.get(3)); 
        System.out.println(lru.get(4)); 
    }
}

}
