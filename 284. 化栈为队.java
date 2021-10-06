import java.util.*;

// 实现一个MyQueue类，该类用两个栈来实现一个队列。

// 示例：

// MyQueue queue = new MyQueue();

// queue.push(1);
// queue.push(2);
// queue.peek();  // 返回 1
// queue.pop();   // 返回 1
// queue.empty(); // 返回 false

// 说明：

// 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
// 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
// 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
class MyQueue {
    private Stack<Integer> left;
    private Stack<Integer> right;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.left = new Stack<>();
        this.right = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!this.right.isEmpty()) {
            this.left.push(this.right.pop());
        }
        this.left.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!this.left.isEmpty()) {
            this.right.push(this.left.pop());
        }
        return this.right.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!this.left.isEmpty()) {
            this.right.push(this.left.pop());
        }
        return this.right.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.left.isEmpty() && this.right.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */