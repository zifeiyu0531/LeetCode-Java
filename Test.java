import java.util.*;

class Solution {
    public int evalSuf(String[] suffix) {
        Stack<Integer> stack = new Stack<Integer>();
        String regex = "^-?\\d+$";
        for (String str : suffix) {
            if (str.matches(regex)) {
                stack.push(Integer.parseInt(str));
            } else {
                int num1 = stack.pop(), num2 = stack.pop();
                switch (str) {
                    case "+":
                        num2 += num1;
                        break;
                    case "-":
                        num2 -= num1;
                        break;
                    case "*":
                        num2 *= num1;
                        break;
                    case "/":
                        num2 /= num1;
                        break;
                }
                stack.push(num2);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] suffix = { "56", "20", "+", "4", "2", "*", "/" };
        System.out.println(solution.evalSuf(suffix));
    }
}