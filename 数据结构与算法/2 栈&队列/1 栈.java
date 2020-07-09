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

// 栈类型Stack
class MyStack<T> {
    StackNode<T> head;

    public MyStack() {
        head = new StackNode<T>();
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 元素e进栈
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