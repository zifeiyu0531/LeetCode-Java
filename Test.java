import sun.jvm.hotspot.tools.SysPropsDumper;

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
    public void add(int index, T val) {
        if (index < 0 || index > this.size()) {
            throw new NullPointerException();
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

    // 获取链表指定位置元素
    public T get(int index) {
        if (index < 0 || index >= this.size()) {
            throw new NullPointerException();
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
    public LinkedNode<Integer> UnionList(LinkedNode<Integer> LA, LinkedNode<Integer> LB) {
        LinkedNode<Integer> p1 = LA, p2 = LB;
        LinkedNode<Integer> preHead = new LinkedNode<Integer>(-1);
        LinkedNode<Integer> index = preHead;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                index.next = p2;
                break;
            } else if (p2 == null) {
                index.next = p1;
                break;
            } else {
                if (p1.val < p2.val) {
                    index.next = p1;
                    p1 = p1.next;
                } else {
                    index.next = p2;
                    p2 = p2.next;
                }
            }
            index = index.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
        MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
        list1.add(1);
        list1.add(4);
        list1.add(6);
        list1.add(9);
        list2.add(2);
        list2.add(3);
        list2.add(8);
        list2.add(10);
        list1.head.next = solution.UnionList(list1.getHead(), list2.getHead());
        System.out.println(list1.toString());
    }
}