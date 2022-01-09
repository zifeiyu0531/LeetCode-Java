import java.util.Deque;
import java.util.LinkedList;

// 给定一个经过编码的字符串，返回它解码后的字符串。

// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

//  

// 示例 1：

// 输入：s = "3[a]2[bc]"
// 输出："aaabcbc"
// 示例 2：

// 输入：s = "3[a2[c]]"
// 输出："accaccacc"
// 示例 3：

// 输入：s = "2[abc]3[cd]ef"
// 输出："abcabccdcdcdef"
// 示例 4：

// 输入：s = "abc3[cd]xyz"
// 输出："abccdcdcdxyz"
class Solution_351 {
    public String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        String numStr = "";
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                numStr += ch;
                continue;
            }
            if (!numStr.isEmpty()) {
                stack.push(numStr);
                numStr = "";
            }
            if (ch != ']') {
                stack.push(String.valueOf(ch));
                continue;
            }
            String tempStr = "";
            while (!stack.isEmpty()) {
                String str = stack.pop();
                if (str.equals("[")) {
                    break;
                }
                tempStr = str + tempStr;
            }
            int times = Integer.valueOf(stack.pop());
            String tempSum = "";
            for (int t = 0; t < times; t++) {
                tempSum += tempStr;
            }
            stack.push(tempSum);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String args[]) {
        Solution_351 solution = new Solution_351();
        String s_1 = "3[a]2[bc]", s_2 = "3[a2[c]]", s_3 = "2[abc]3[cd]ef", s_4 = "abc3[cd]xyz";
        System.out.println(solution.decodeString(s_1));
        System.out.println(solution.decodeString(s_2));
        System.out.println(solution.decodeString(s_3));
        System.out.println(solution.decodeString(s_4));
    }
}