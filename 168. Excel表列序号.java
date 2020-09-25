// 给定一个Excel表格中的列名称，返回其相应的列序号。

// 例如，

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...
// 示例 1:

// 输入: "A"
// 输出: 1
// 示例 2:

// 输入: "AB"
// 输出: 28
// 示例 3:

// 输入: "ZY"
// 输出: 701

class Solution_168 {
    public int titleToNumber(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                num *= 26;
            }
            char ch = s.charAt(i);
            num += ch - 'A' + 1;
        }
        return num;
    }

    public static void main(String args[]) {
        Solution_168 solution = new Solution_168();
        String s_1 = "A", s_2 = "AB", s_3 = "ZY";
        System.out.println(solution.titleToNumber(s_1));
        System.out.println(solution.titleToNumber(s_2));
        System.out.println(solution.titleToNumber(s_3));
    }
}