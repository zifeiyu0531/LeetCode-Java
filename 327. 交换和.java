import java.util.*;

// 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。

// 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。

// 示例:

// 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
// 输出: [1, 3]
// 示例:

// 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
// 输出: []
// 提示：

// 1 <= array1.length, array2.length <= 100000
class Solution_327 {
    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : array1) {
            sum1 += num;
        }
        for (int num : array2) {
            sum2 += num;
            set.add(num);
        }
        int diff = sum1 - sum2;
        if (diff % 2 != 0) {
            return new int[0];
        }
        diff /= 2;
        for (int num : array1) {
            int target = num - diff;
            if (set.contains(target)) {
                return new int[] { num, target };
            }
        }
        return new int[0];
    }

    public static void main(String args[]) {
        Solution_327 solution = new Solution_327();
        int[] array1_1 = { 4, 1, 2, 1, 1, 2 }, array1_2 = { 1, 2, 3 };
        int[] array2_1 = { 3, 6, 3, 3 }, array2_2 = { 4, 5, 6 };
        System.out.println(Arrays.toString(solution.findSwapValues(array1_1, array2_1)));
        System.out.println(Arrays.toString(solution.findSwapValues(array1_2, array2_2)));
    }
}