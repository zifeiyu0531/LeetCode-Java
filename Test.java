import java.util.*;
// 栈节点StackNode
class StackNode<T> {
    public T val;
    public StackNode<T> next;

    public StackNode() {
        this(null);
    }

    public StackNode(T val) {
        this.val = val;
        this.next = null;
    }
}

// 栈类型MyStack
class MyStack<T> {
    StackNode<T> head;

    public MyStack() {
        head = new StackNode<T>();
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 元素进栈
    public void push(T e) {
        StackNode<T> p = new StackNode<T>(e);
        p.next = head.next;
        head.next = p;
    }

    // 栈顶元素出栈
    public T pop() {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        T val = head.next.val;
        head.next = head.next.next;
        return val;
    }

    // 取栈顶元素
    public T peek() {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        T val = head.next.val;
        return val;
    }

    // 打印栈
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }
        String str = "";
        StackNode<T> node = head;
        while (node.next.next != null) {
            node = node.next;
            str += node.val + "->";
        }
        str += node.next.val;
        return str;
    }
}
class Solution {
    public String[] InfToSuf(String infix) {
        List<String> suffix = new ArrayList<String>();
        MyStack<String> stack = new MyStack<String>();
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "(56+20)/(4*2)";
        System.out.println(Arrays.toString(solution.InfToSuf(str)));
    }
}