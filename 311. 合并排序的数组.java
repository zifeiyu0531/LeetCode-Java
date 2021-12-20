import java.util.Arrays;

// 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

// 初始化 A 和 B 的元素数量分别为 m 和 n。

// 示例:

// 输入:
// A = [1,2,3,0,0,0], m = 3
// B = [2,5,6],       n = 3

// 输出: [1,2,2,3,5,6]
// 说明:

// A.length == n + m
class Solution_311 {
    public void merge(int[] A, int m, int[] B, int n) {
        for (int tail = A.length - 1; tail >= 0; tail--) {
            int a = m > 0 ? A[m - 1] : Integer.MIN_VALUE;
            int b = n > 0 ? B[n - 1] : Integer.MIN_VALUE;
            if (a > b) {
                A[tail] = a;
                m--;
            } else {
                A[tail] = b;
                n--;
            }
        }
    }

    public static void main(String args[]) {
        Solution_311 solution = new Solution_311();
        int[] A = { 1, 2, 3, 0, 0, 0 };
        int[] B = { 2, 5, 6 };
        int m = 3, n = 3;
        solution.merge(A, m, B, n);
        System.out.println(Arrays.toString(A));
    }
}