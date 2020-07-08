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

    // 获取表头
    public LinkedNode getHead() {
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
        LinkedNode p = head;
        int n = 0;
        while (n < index) {
            p = p.next;
            n++;
        }
        LinkedNode node = new LinkedNode(val);
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
            n++;
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
            n++;
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
    public void UnionList(LinkedNode LA, LinkedNode LB) {
        LinkedNode p1 = LA.next, p2 = LB.next;
        LinkedNode index = LA;
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
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(7);
        LinkedList list2 = new LinkedList();
        list2.add(1);
        list2.add(4);
        list2.add(5);
        list2.add(7);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        Solution solution = new Solution();
        solution.UnionList(list1.getHead(), list2.getHead());
        System.out.println(list1.toString());
    }
}