# 📘 README: LRU Cache & Custom HashMap (Java)

## 🚀 Assignment 1: LRU Cache

### ✅ Problem Statement
Design an LRU (Least Recently Used) Cache that supports:

- `get(key)`: Returns the value if the key exists, otherwise `-1`.
- `put(key, value)`: Inserts or updates the value. If the capacity is exceeded, remove the least recently used item.

All operations must run in **O(1)** time complexity.

### ✅ Constraints
- `1 <= capacity <= 3000`
- `0 <= key, value <= 10⁴`
- Maximum number of operations: `10⁵`

### ✅ Approach
- Use a **HashMap** for key-to-node lookup.
- Use a **Doubly Linked List** to maintain usage order (most recently used at the front).

### ✅ Example Usage
```java
LRUCache lru = new LRUCache(2);
lru.put(1, 1);
lru.put(2, 2);
System.out.println(lru.get(1)); // returns 1
lru.put(3, 3); // evicts key 2
System.out.println(lru.get(2)); // returns -1
lru.put(4, 4); // evicts key 1
System.out.println(lru.get(1)); // returns -1
System.out.println(lru.get(3)); // returns 3
System.out.println(lru.get(4)); // returns 4



### # 🧩 Custom HashMap in Java

## ✅ Problem Statement

Implement a simplified version of a **HashMap** (also known as dictionary or unordered map) **without using any built-in hash table libraries** such as `HashMap`, `Map`, `Dict`, etc.

### Required Operations:
- `put(key, value)` → Insert or update the value by key.
- `get(key)` → Return the value associated with the key. If not found, return `-1`.
- `remove(key)` → Remove the key from the map.

---

## ✅ Constraints

- All keys and values are integers.
- `0 <= key, value <= 10^6`
- Maximum number of operations: `10^5`
- Keys are unique within the map.
- Average-case time complexity for each operation should be **O(1)**.

---

## ✅ Approach

- We use **separate chaining** (array of linked lists) to handle hash collisions.
- The size of the underlying array is a **prime number (10007)** to reduce clustering.
- Each element in the array (bucket) holds a linked list of key-value pairs that hash to the same index.

---

## ✅ Class Definition

```java
class MyHashMap {
    public MyHashMap();
    public void put(int key, int value);
    public int get(int key);
    public void remove(int key);
}




