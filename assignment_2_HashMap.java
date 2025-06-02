class assignment_2_HashMap {

    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 10007; // A prime number helps distribute keys better
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = buckets[index];

        // Check if key exists and update
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
        }

        // Otherwise insert new node at head
        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        while (curr != null) {
            if (curr.key == key) return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[index] = curr.next; // Remove head
                } else {
                    prev.next = curr.next; // Bypass current node
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
  public class Main {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 10);
        obj.put(2, 20);
        System.out.println(obj.get(1));  // 10
        System.out.println(obj.get(3));  // -1
        obj.put(2, 30);                 
        System.out.println(obj.get(2));  // 30
        obj.remove(2);
        System.out.println(obj.get(2));  // -1
    }
}

}
