package 牛客TOP100;

import java.util.*;

class Solution {
    /**
     * lru design
     * 
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        Lru lru = new Lru(k);
        List<Integer> list = new ArrayList<>();
        for (int[] op : operators) {
            if (op[0] == 1) {
                lru.set(op[1], op[2]);
            } else {
                list.add(lru.get(op[1]));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}

class Lru {
    private int size;
    private Queue<Integer> queue;
    private Map<Integer, Integer> map;

    public Lru(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.map = new HashMap<>();
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
        } else {
            if (queue.size() == size) {
                int oldKey = queue.poll();
                map.remove(oldKey);
            }
        }
        map.put(key, value);
        queue.offer(key);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.offer(key);
        }
        return map.getOrDefault(key, -1);
    }
}