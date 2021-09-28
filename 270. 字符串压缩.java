// 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

// 示例1:

//  输入："aabcccccaaa"
//  输出："a2b1c5a3"
// 示例2:

//  输入："abbccd"
//  输出："abbccd"
//  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 提示：

// 字符串长度在[0, 50000]范围内。
class Solution_270 {
    public String compressString(String S) {
        if (S.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char curr = S.charAt(0);
        int count = 1;
        for (int i = 1; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (curr == ch) {
                count++;
            } else {
                sb.append(curr);
                sb.append(count);
                curr = ch;
                count = 1;
            }
        }
        sb.append(curr);
        sb.append(count);
        return sb.length() >= S.length() ? S : sb.toString();
    }

    public static void main(String args[]) {
        Solution_270 solution = new Solution_270();
        String S_1 = "aabcccccaaa", S_2 = "abbccd";
        System.out.println(solution.compressString(S_1));
        System.out.println(solution.compressString(S_2));
    }
}