import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。

// 示例：

// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
// 输出： [1,2,3,4]
// 提示：

// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
class Solution_334 {
    public int[] smallestK(int[] arr, int k) {
        int[] res = new int[k];
        if (k <= 0) {
            return res;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (heap.peek() > arr[i]) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_334 solution = new Solution_334();
        int[] arr = { 1, 3, 5, 7, 2, 4, 6, 8 };
        int k = 4;
        System.out.println(Arrays.toString(solution.smallestK(arr, k)));
    }
}