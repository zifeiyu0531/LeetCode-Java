// 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

// 如果不存在最后一个单词，请返回 0 。

// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

//  

// 示例:

// 输入: "Hello World"
// 输出: 5

class Solution_77 {
    public int lengthOfLastWord(String s) {
        int left = 0, right = 0;
        String new_str = s.trim();
        if (new_str.length() == 0) {
            return 0;
        }
        while (right < new_str.length()) {
            if (new_str.charAt(right) == ' ') {
                left = right + 1;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String args[]) {
        Solution_77 solution = new Solution_77();
        String s_1 = "Hello World";
        System.out.println(solution.lengthOfLastWord(s_1));
    }
}