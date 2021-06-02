import java.util.*;

// 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

//  

// 示例 1：

// 输入：arr = [3,2,1], k = 2
// 输出：[1,2] 或者 [2,1]
// 示例 2：

// 输入：arr = [0,1,2,1], k = 1
// 输出：[0]
//  

// 限制：

// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
class Solution_225 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] result = new int[k];
        if (k == 0) {
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < queue.peek()) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String args[]) {
        Solution_225 solution = new Solution_225();
        int[] arr_1 = { 3, 2, 1 }, arr_2 = { 0, 1, 2, 1 };
        int k_1 = 2, k_2 = 1;
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr_1, k_1)));
        System.out.println(Arrays.toString(solution.getLeastNumbers(arr_2, k_2)));
    }
}