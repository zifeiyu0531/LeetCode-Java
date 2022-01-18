package 牛客TOP100;

import java.util.*;

class Solution {
    /**
     * 
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        int res = 0;
        for (int num : arr) {
            while (queue.contains(num)) {
                queue.poll();
            }
            queue.offer(num);
            res = Math.max(res, queue.size());
        }
        return res;
    }
}