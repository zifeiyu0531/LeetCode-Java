import java.util.Arrays;

// 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。

// 示例：

// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
// 输出： [3,9]
// 提示：

// 0 <= len(array) <= 1000000
class Solution_324 {
    public int[] subSort(int[] array) {
        int left = -1, right = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i] < max) {
                right = i;
            } else {
                max = Math.max(max, array[i]);
            }

            if (array[n - i - 1] > min) {
                left = n - i - 1;
            } else {
                min = Math.min(min, array[n - i - 1]);
            }
        }
        return new int[] { left, right };
    }

    public static void main(String args[]) {
        Solution_324 solution = new Solution_324();
        int[] array = { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };
        System.out.println(Arrays.toString(solution.subSort(array)));
    }
}