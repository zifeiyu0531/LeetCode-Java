// 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

//  

// 示例 1：

// 输入: n = 3
// 输出: 6
// 示例 2：

// 输入: n = 9
// 输出: 45
//  

// 限制：

// 1 <= n <= 10000

class Solution_22 {
    public int sumNums(int n) {
        boolean b = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String args[]) {
        Solution_22 solution = new Solution_22();
        int n_1 = 3, n_2 = 9;
        System.out.println(solution.sumNums(n_1));
        System.out.println(solution.sumNums(n_2));
    }
}