// 链表节点LinkedNode
class LinkedNode<T> {
    public T val;
    public LinkedNode<T> next;

    public LinkedNode() {
        this(null);
    }

    public LinkedNode(T val) {
        this.val = val;
        this.next = null;
    }
}

// 链表LinkedList
class MyLinkedList<T> {
    public LinkedNode<T> head;

    public MyLinkedList() {
        this.head = new LinkedNode<T>();
        head.next = null;
    }

    // 获取表头
    public LinkedNode<T> getHead() {
        if (this.isEmpty()) {
            throw new NullPointerException();
        }
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
    public boolean add(int index, T val) {
        if (index < 0 || index > this.size()) {
            return false;
        }
        LinkedNode<T> p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        LinkedNode<T> node = new LinkedNode<T>(val);
        node.next = p.next;
        p.next = node;
        return true;
    }

    // 移除链表末尾元素
    public T remove() {
        return this.remove(this.size() - 1);
    }

    // 移除链表指定位置元素。若不存在，返回null
    public T remove(int index) {
        if (index >= this.size()) {
            return null;
        }
        LinkedNode<T> p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        T val = p.next.val;
        p.next = p.next.next;
        return val;
    }

    // 获取链表指定位置元素。若不存在，返回null
    public T get(int index) {
        if (index >= this.size()) {
            return null;
        }
        LinkedNode<T> p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        return p.next.val;
    }

    // 获取链表长度
    public int size() {
        LinkedNode<T> p = head;
        int n = 0;
        while (p.next != null) {
            p = p.next;
            n++;
        }
        return n;
    }

    // 输出链表
    public String toString() {
        LinkedNode<T> p = head;
        String str = "";
        if (p.next == null) {
            return "";
        }
        while (p.next.next != null) {
            p = p.next;
            str += p.val + "->";
        }
        str += p.next.val;
        return str;
    }
}

class Solution {
    public LinkedNode<Integer> sort(LinkedNode<Integer> head) {
        if (head == null) {
            return null;
        }
        LinkedNode<Integer> preHead = new LinkedNode<Integer>(-1);
        preHead.next = head;
        LinkedNode<Integer> p = preHead, q = head.next;
        head.next = null;
        while (q != null) {
            LinkedNode<Integer> temp = q.next;
            p = preHead;
            while (p.next != null && p.next.val <= q.val) {
                p = p.next;
            }
            q.next = p.next;
            p.next = q;
            q = temp;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(5);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(list.toString());
        list.head.next = solution.sort(list.getHead());
        System.out.println(list.toString());
    }
}