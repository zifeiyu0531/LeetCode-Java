import java.util.*;

// 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

//  

// 示例:

// 输入: [1,2,3,4,5]
// 输出: [120,60,40,30,24]
//  

// 提示：

// 所有元素乘积之和不会溢出 32 位整数
// a.length <= 100000
class Solution_263 {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if (n == 0) {
            return new int[] {};
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        int temp = 1;
        for (int i = n - 1; i > 0; i--) {
            temp *= a[i];
            res[i - 1] *= temp;
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_263 solution = new Solution_263();
        int[] a = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(solution.constructArr(a)));
    }
}