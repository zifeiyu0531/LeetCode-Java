package 牛客TOP100;

import java.util.*;

class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        for (int num : input) {
            if (heap.size() < k) {
                heap.offer(num);
            } else {
                if (heap.peek() > num) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        return res;
    }
}