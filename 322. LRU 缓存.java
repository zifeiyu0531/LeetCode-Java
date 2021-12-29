import java.util.*;
import java.util.LinkedList;

// 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。

// 它应该支持以下操作： 获取数据 get 和 写入数据 put 。

// 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
// 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

// 示例:

// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // 返回  1
// cache.put(3, 3);    // 该操作会使得密钥 2 作废
// cache.get(2);       // 返回 -1 (未找到)
// cache.put(4, 4);    // 该操作会使得密钥 1 作废
// cache.get(1);       // 返回 -1 (未找到)
// cache.get(3);       // 返回  3
// cache.get(4);       // 返回  4
class LRUCache {
    private Map<Integer, Integer> map;
    private Deque<Integer> queue;
    private int count;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.queue = new LinkedList<>();
        this.count = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        this.queue.remove(key);
        this.queue.addFirst(key);
        return this.map.get(key);
    }

    public void put(int key, int value) {
        if (this.count == this.capacity) {
            int oldKey = queue.removeLast();
            this.map.remove(oldKey);
        }
        if (!this.map.containsKey(key)) {
            this.count++;
        } else {
            this.queue.remove(key);
        }
        this.map.put(key, value);
        this.queue.addFirst(key);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */