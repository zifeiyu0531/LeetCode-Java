class Solution_2 {
    /**
     * 后缀表达式求值
     * 
     * @param suffix 后缀表达式的数组形式
     * @return 求得的值(整数形式)
     */
    public int evalSuf(String[] suffix) {
        MyStack<Integer> stack = new MyStack<Integer>();
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
}