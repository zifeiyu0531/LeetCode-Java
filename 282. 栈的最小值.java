// 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。

// 示例：

// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.
class MinStack {
    private int[] stack;
    private int[] minStack;
    private int top;
    private int minTop;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new int[10000];
        this.minStack = new int[10000];
        this.top = 0;
        this.minTop = 0;
    }

    public void push(int x) {
        this.stack[this.top] = x;
        this.top++;
        if (this.minTop == 0 || this.minStack[minTop - 1] >= x) {
            this.minStack[minTop] = x;
            this.minTop++;
        }
    }

    public void pop() {
        if (this.top <= 0) {
            return;
        }
        this.top--;
        if (this.stack[this.top] == this.minStack[this.minTop - 1]) {
            this.minTop--;
        }
    }

    public int top() {
        return this.stack[this.top - 1];
    }

    public int getMin() {
        return this.minStack[this.minTop - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */