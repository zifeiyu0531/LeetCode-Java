import java.util.*;

class Solution_1 {
    /**
     * 中缀表达式转后缀表达式
     * 
     * @param Infix 中缀表达式
     * @return 后缀表达式的数组形式
     */
    public String[] InfToSuf(String infix) {
        List<String> suffix = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < infix.length(); i++) {
            int j = i + 1;
            String regex = "^-?\\d+$";
            while (j <= infix.length() && infix.substring(i, j).matches(regex)) {
                j++;
            }
            if (j > i + 1) {
                String num = infix.substring(i, j - 1);
                suffix.add(num);
                i = j - 2;
            } else {
                String str = infix.substring(i, i + 1);
                switch (str) {
                    case "(":
                        stack.push(str);
                        break;
                    case ")":
                        while (!stack.peek().equals("(")) {
                            suffix.add(stack.pop());
                        }
                        stack.pop();
                        break;
                    case "+":
                    case "-":
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            suffix.add(stack.pop());
                        }
                        stack.push(str);
                        break;
                    case "*":
                    case "/":
                        while (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("+")
                                && !stack.peek().equals("-")) {
                            suffix.add(stack.pop());
                        }
                        stack.push(str);
                        break;
                }
            }
        }
        while (!stack.isEmpty()) {
            suffix.add(stack.pop());
        }
        String[] array = new String[suffix.size()];
        suffix.toArray(array);
        return array;
    }
}