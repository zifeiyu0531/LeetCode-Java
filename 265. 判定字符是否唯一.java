// 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

// 示例 1：

// 输入: s = "leetcode"
// 输出: false 
// 示例 2：

// 输入: s = "abc"
// 输出: true
// 限制：

// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
class Solution_265 {
    public boolean isUnique(String astr) {
        int res = 0;
        for (char ch : astr.toCharArray()) {
            int offset = ch - 'a';
            int temp = 1 << offset;
            if ((res & temp) != 0) {
                return false;
            }
            res |= temp;
        }
        return true;
    }

    public static void main(String args[]) {
        Solution_265 solution = new Solution_265();
        String s_1 = "leetcode", s_2 = "abc";
        System.out.println(solution.isUnique(s_1));
        System.out.println(solution.isUnique(s_2));
    }
}