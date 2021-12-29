import java.util.Arrays;

// 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差

//  

// 示例：

// 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
// 输出：3，即数值对(11, 8)
//  

// 提示：

// 1 <= a.length, b.length <= 100000
// -2147483648 <= a[i], b[i] <= 2147483647
// 正确结果在区间 [0, 2147483647] 内
class Solution_320 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        long diff = Long.MAX_VALUE;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return 0;
            }
            if (a[i] < b[j]) {
                diff = Math.min(diff, (long) b[j] - (long) a[i]);
                i++;
            } else {
                diff = Math.min(diff, (long) a[i] - (long) b[j]);
                j++;
            }
        }
        return (int) diff;
    }

    public static void main(String args[]) {
        Solution_320 solution = new Solution_320();
        int[] a = { 1, 3, 15, 11, 2 }, b = { 23, 127, 235, 19, 8 };
        System.out.println(solution.smallestDifference(a, b));
    }
}