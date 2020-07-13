// 给定一个正整数，返回它在 Excel 表中相对应的列名称。

// 例如，

//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
//     ...
// 示例 1:

// 输入: 1
// 输出: "A"
// 示例 2:

// 输入: 28
// 输出: "AB"
// 示例 3:

// 输入: 701
// 输出: "ZY"

class Solution_166 {
    public String convertToTitle(int n) {
        String str = "";
        while (n != 0) {
            int res = (n % 26) - 1;
            if (res == -1) {
                str = 'Z' + str;
            } else {
                str = (char) ('A' + res) + str;
            }
            n--;
            n /= 26;
        }
        return str;
    }

    public static void main(String args[]) {
        Solution_166 solution = new Solution_166();
        int n_1 = 1, n_2 = 28, n_3 = 701;
        System.out.println(solution.convertToTitle(n_1));
        System.out.println(solution.convertToTitle(n_2));
        System.out.println(solution.convertToTitle(n_3));
    }
}