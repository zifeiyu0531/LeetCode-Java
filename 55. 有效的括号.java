import java.util.Stack;

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

// 有效字符串需满足：

// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。

// 示例 1:

// 输入: "()"
// 输出: true
// 示例 2:

// 输入: "()[]{}"
// 输出: true
// 示例 3:

// 输入: "(]"
// 输出: false
// 示例 4:

// 输入: "([)]"
// 输出: false
// 示例 5:

// 输入: "{[]}"
// 输出: true

class Solution_55 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    st.push(ch);
                    break;
                case ')':
                    if (!st.empty() && st.peek() == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    st.push(ch);
                    break;
                case ']':
                    if (!st.empty() && st.peek() == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    st.push(ch);
                    break;
                case '}':
                    if (!st.empty() && st.peek() == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if (st.empty())
            return true;
        return false;
    }

    public static void main(String args[]) {
        Solution_55 solution = new Solution_55();
        String s_1 = "()", s_2 = "()[]{}", s_3 = "(]", s_4 = "([)]", s_5 = "{[]}";
        System.out.println(solution.isValid(s_1));
        System.out.println(solution.isValid(s_2));
        System.out.println(solution.isValid(s_3));
        System.out.println(solution.isValid(s_4));
        System.out.println(solution.isValid(s_5));
    }
}