// 双链表节点DlinkedNode
class DLinkedNode {
    public int val;
    public DLinkedNode next;
    public DLinkedNode pre;

    public DLinkedNode() {
        this(-1);
    }

    public DLinkedNode(int val) {
        this.val = val;
        this.next = null;
        this.pre = null;
    }
}

// 双链表DLinkedList
class DLinkedList {
    public DLinkedNode head;

    public DLinkedList() {
        this.head = new DLinkedNode();
    }

    // 获取表头
    public DLinkedNode getHead() {
        return head;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 向链表末尾添加元素
    public void add(int val) {
        this.add(this.size(), val);
    }

    // 向链表指定位置添加元素
    public boolean add(int index, int val) {
        if (index < 0 || index > this.size()) {
            return false;
        }
        DLinkedNode p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        DLinkedNode node = new DLinkedNode(val);
        node.next = p.next;
        if (p.next != null) {
            p.next.pre = node;
        }
        p.next = node;
        node.pre = p;
        return true;
    }

    // 移除链表末尾元素
    public DLinkedNode remove() {
        return this.remove(this.size() - 1);
    }

    // 移除链表指定位置元素。若不存在，返回null
    public DLinkedNode remove(int index) {
        if (index >= this.size()) {
            return null;
        }
        DLinkedNode p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        DLinkedNode node = p.next;
        p.next = p.next.next;
        if (p.next != null) {
            p.next.pre = p;
        }
        return node;
    }

    // 获取链表指定位置元素。若不存在，返回null
    public DLinkedNode get(int index) {
        if (index >= this.size()) {
            return null;
        }
        DLinkedNode p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        return p.next;
    }

    // 获取链表长度
    public int size() {
        DLinkedNode p = head;
        int n = 0;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        return n;
    }

    // 输出链表
    public String toString() {
        DLinkedNode p = head;
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