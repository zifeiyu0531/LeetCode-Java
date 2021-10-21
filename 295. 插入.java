// 给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。

// 编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。

// 题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。

//  

// 示例1:

//  输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
//  输出：N = 1100(10001001100)
// 示例2:

//  输入： N = 0, M = 31(11111), i = 0, j = 4
//  输出：N = 31(11111)
class Solution_295 {
    public int insertBits(int N, int M, int i, int j) {
        int left = N >> j >> 1;
        left = left << j << 1;
        int middle = M << i;
        int right = N & ((1 << i) - 1);
        return left | middle | right;
    }

    public static void main(String args[]) {
        Solution_295 solution = new Solution_295();
        int N_1 = 1024, N_2 = 0;
        int M_1 = 19, M_2 = 31;
        int i_1 = 2, i_2 = 0;
        int j_1 = 6, j_2 = 4;
        System.out.println(solution.insertBits(N_1, M_1, i_1, j_1));
        System.out.println(solution.insertBits(N_2, M_2, i_2, j_2));
    }
}