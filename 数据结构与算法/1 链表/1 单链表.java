// 链表节点LinkedNode
class LinkedNode {
    public int val;
    public LinkedNode next;

    public LinkedNode() {
        this(-1);
    }

    public LinkedNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// 链表LinkedList
class LinkedList {
    public LinkedNode head;

    public LinkedList() {
        this.head = new LinkedNode();
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    // 向链表末尾添加元素
    public void add(LinkedNode node) {
        this.add(this.size(), node);
    }

    // 向链表指定位置添加元素
    public boolean add(int index, LinkedNode node) {
        if (index < 0 || index > this.size()) {
            return false;
        }
        LinkedNode p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        node.next = p.next;
        p.next = node;
        return true;
    }

    // 移除链表末尾元素
    public LinkedNode remove() {
        return this.remove(this.size() - 1);
    }

    // 移除链表指定位置元素。若不存在，返回null
    public LinkedNode remove(int index) {
        if (index >= this.size()) {
            return null;
        }
        LinkedNode p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
        }
        LinkedNode node = p.next;
        p.next = p.next.next;
        return node;
    }

    // 获取链表指定位置元素。若不存在，返回null
    public LinkedNode get(int index) {
        if (index >= this.size()) {
            return null;
        }
        LinkedNode p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
        }
        return p.next;
    }

    // 获取链表长度
    public int size() {
        LinkedNode p = head;
        int n = 0;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        return n;
    }

    // 输出链表
    public String toString() {
        LinkedNode p = head;
        String str = "";
        while (p.next.next != null) {
            p = p.next;
            str += p.val + "->";
        }
        str += p.next.val;
        return str;
    }
}