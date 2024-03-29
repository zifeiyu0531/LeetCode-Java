// 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

// 示例1:

//  输入：s1 = "waterbottle", s2 = "erbottlewat"
//  输出：True
// 示例2:

//  输入：s1 = "aa", s2 = "aba"
//  输出：False
// 提示：

// 字符串长度在[0, 100000]范围内。
// 说明:

// 你能只调用一次检查子串的方法吗？
class Solution_273 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }

    public static void main(String args[]) {
        Solution_273 solution = new Solution_273();
        String s1_1 = "waterbottle", s1_2 = "aa";
        String s2_1 = "erbottlewat", s2_2 = "aba";
        System.out.println(solution.isFlipedString(s1_1, s2_1));
        System.out.println(solution.isFlipedString(s1_2, s2_2));
    }
}