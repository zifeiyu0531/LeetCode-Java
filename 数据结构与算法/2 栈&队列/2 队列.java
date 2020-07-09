// 队列节点QueueNode
class QueueNode<T> {
    public T val;
    public QueueNode<T> next;

    public QueueNode() {
        this(null);
    }

    public QueueNode(T val) {
        this.val = val;
        this.next = null;
    }
}

// 队列类型MyQueue
class MyQueue<T> {
    QueueNode<T> head;
    QueueNode<T> tail;

    public MyQueue() {
        head = null;
        tail = null;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return tail == null;
    }

    // 元素进队
    public void offer(T e) {
        QueueNode<T> node = new QueueNode<T>(e);
        if (this.isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    // 元素出队
    public T poll() {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        T val = head.val;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        return val;
    }

    // 取队首元素
    public T element() {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
        return head.val;
    }

    // 打印队列
    public String toString() {
        if (this.isEmpty()) {
            return "";
        }
        QueueNode<T> node = head;
        String str = "[";
        while (node.next != null) {
            str += node.val + ", ";
            node = node.next;
        }
        str += node.val + "]";
        return str;
    }
}