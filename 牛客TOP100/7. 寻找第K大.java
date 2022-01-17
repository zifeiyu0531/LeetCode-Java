package 牛客TOP100;

import java.util.*;

class Solution {
    public int findKth(int[] a, int n, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (int num : a) {
            if (heap.size() < K) {
                heap.offer(num);
            } else {
                if (heap.peek() < num) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        return heap.peek();
    }
}