// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

// 数值（按顺序）可以分成以下几个部分：

// 若干空格
// 一个 小数 或者 整数
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数
// 若干空格
// 小数（按顺序）可以分成以下几个部分：

// （可选）一个符号字符（'+' 或 '-'）
// 下述格式之一：
// 至少一位数字，后面跟着一个点 '.'
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
// 一个点 '.' ，后面跟着至少一位数字
// 整数（按顺序）可以分成以下几个部分：

// （可选）一个符号字符（'+' 或 '-'）
// 至少一位数字
// 部分数值列举如下：

// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
// 部分非数值列举如下：

// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
//  

// 示例 1：

// 输入：s = "0"
// 输出：true
// 示例 2：

// 输入：s = "e"
// 输出：false
// 示例 3：

// 输入：s = "."
// 输出：false
// 示例 4：

// 输入：s = "    .1  "
// 输出：true
//  

// 提示：

// 1 <= s.length <= 20
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
class Solution_244 {
    public boolean isNumber(String s) {
        s = s.trim();
        int state = 0;
        for (char ch : s.toCharArray()) {
            switch (state) {
                case 0:
                    if (ch == '+' || ch == '-') {
                        state = 1;
                    } else if (ch == '.') {
                        state = 7;
                    } else if (ch >= '0' && ch <= '9') {
                        state = 2;
                    } else {
                        return false;
                    }
                    break;
                case 1:
                    if (ch >= '0' && ch <= '9') {
                        state = 2;
                    } else if (ch == '.') {
                        state = 7;
                    } else {
                        return false;
                    }
                    break;
                case 2:
                    if (ch >= '0' && ch <= '9') {
                        break;
                    } else if (ch == '.') {
                        state = 3;
                    } else if (ch == 'e' || ch == 'E') {
                        state = 4;
                    } else {
                        return false;
                    }
                    break;
                case 3:
                    if (ch >= '0' && ch <= '9') {
                        break;
                    } else if (ch == 'e' || ch == 'E') {
                        state = 4;
                    } else {
                        return false;
                    }
                    break;
                case 4:
                    if (ch == '+' || ch == '-') {
                        state = 5;
                    } else if (ch >= '0' && ch <= '9') {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                case 5:
                    if (ch >= '0' && ch <= '9') {
                        state = 6;
                    } else {
                        return false;
                    }
                    break;
                case 6:
                    if (ch >= '0' && ch <= '9') {
                        break;
                    } else {
                        return false;
                    }
                case 7:
                    if (ch >= '0' && ch <= '9') {
                        state = 3;
                    } else {
                        return false;
                    }
            }
        }
        if (state == 0 || state == 1 || state == 4 || state == 5 || state == 7) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        Solution_244 solution = new Solution_244();
        String s_1 = "0", s_2 = "e", s_3 = ".", s_4 = "    .1  ";
        System.out.println(solution.isNumber(s_1));
        System.out.println(solution.isNumber(s_2));
        System.out.println(solution.isNumber(s_3));
        System.out.println(solution.isNumber(s_4));
    }
}