// 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

//  

// 示例:

// 输入: a = 1, b = 1
// 输出: 2
//  

// 提示：

// a, b 均可能是负数或 0
// 结果不会溢出 32 位整数
class Solution_238 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String args[]) {
        Solution_238 solution = new Solution_238();
        int a = 1;
        int b = 1;
        System.out.println(solution.add(a, b));
    }
}