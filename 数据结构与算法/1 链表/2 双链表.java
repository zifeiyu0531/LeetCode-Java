// 双链表节点DlinkedNode
class DLinkedNode<T> {
    public T val;
    public DLinkedNode<T> next;
    public DLinkedNode<T> pre;

    public DLinkedNode() {
        this(null);
    }

    public DLinkedNode(T val) {
        this.val = val;
        this.next = null;
        this.pre = null;
    }
}

// 双链表MyDLinkedList
class MyDLinkedList<T> {
    public DLinkedNode<T> head;

    public MyDLinkedList() {
        this.head = new DLinkedNode<T>();
    }

    // 获取表头
    public DLinkedNode<T> getHead() {
        return head.next;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 向链表末尾添加元素
    public void add(T val) {
        this.add(this.size(), val);
    }

    // 向链表指定位置添加元素
    public void add(int index, T val) {
        if (index < 0 || index > this.size()) {
            throw new NullPointerException();
        }
        DLinkedNode<T> p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        DLinkedNode<T> node = new DLinkedNode<T>(val);
        node.next = p.next;
        if (p.next != null) {
            p.next.pre = node;
        }
        p.next = node;
        node.pre = p;
    }

    // 移除链表末尾元素
    public T remove() {
        return this.remove(this.size() - 1);
    }

    // 移除链表指定位置元素
    public T remove(int index) {
        if (index < 0 || index >= this.size()) {
            throw new NullPointerException();
        }
        DLinkedNode<T> p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        DLinkedNode<T> node = p.next;
        p.next = p.next.next;
        if (p.next != null) {
            p.next.pre = p;
        }
        return node.val;
    }

    // 获取链表指定位置元素
    public T get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new NullPointerException();
        }
        DLinkedNode<T> p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        return p.next.val;
    }

    // 获取链表长度
    public int size() {
        DLinkedNode<T> p = head;
        int n = 0;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        return n;
    }

    // 输出链表
    public String toString() {
        DLinkedNode<T> p = head;
        String str = "";
        if (p.next == null) {
            return "";
        }
        while (p.next.next != null) {
            p = p.next;
            str += p.val + "<->";
        }
        str += p.next.val;
        return str;
    }
}