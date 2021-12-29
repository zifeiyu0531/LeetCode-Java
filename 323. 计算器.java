import java.util.Stack;

// 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。

// 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

// 示例 1:

// 输入: "3+2*2"
// 输出: 7
// 示例 2:

// 输入: " 3/2 "
// 输出: 1
// 示例 3:

// 输入: " 3+5 / 2 "
// 输出: 5
// 说明：

// 你可以假设所给定的表达式都是有效的。
// 请不要使用内置的库函数 eval。
class Solution_323 {
    public int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        String num = "";
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (ch >= '0' && ch <= '9') {
                num += ch;
            } else {
                numStack.push(Integer.parseInt(num));
                num = "";
                if (ch == '*' || ch == '/') {
                    while (!opStack.isEmpty() && (opStack.peek() == '*' || opStack.peek() == '/')) {
                        char op = opStack.pop();
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        if (op == '*') {
                            numStack.push(num1 * num2);
                        } else {
                            numStack.push(num1 / num2);
                        }
                    }
                    opStack.push(ch);
                } else {
                    while (!opStack.isEmpty()) {
                        char op = opStack.pop();
                        int num2 = numStack.pop();
                        int num1 = numStack.pop();
                        if (op == '+') {
                            numStack.push(num1 + num2);
                        } else if (op == '-') {
                            numStack.push(num1 - num2);
                        } else if (op == '*') {
                            numStack.push(num1 * num2);
                        } else {
                            numStack.push(num1 / num2);
                        }
                    }
                    opStack.push(ch);
                }
            }
        }

        numStack.push(Integer.parseInt(num));
        while (!opStack.isEmpty()) {
            char op = opStack.pop();
            int num2 = numStack.pop();
            int num1 = numStack.pop();
            if (op == '+') {
                numStack.push(num1 + num2);
            } else if (op == '-') {
                numStack.push(num1 - num2);
            } else if (op == '*') {
                numStack.push(num1 * num2);
            } else {
                numStack.push(num1 / num2);
            }
        }

        return numStack.peek();
    }

    public static void main(String args[]) {
        Solution_323 solution = new Solution_323();
        String s_1 = "3+2*2", s_2 = " 3/2 ", s_3 = " 3+5 / 2 ";
        System.out.println(solution.calculate(s_1));
        System.out.println(solution.calculate(s_2));
        System.out.println(solution.calculate(s_3));
    }
}