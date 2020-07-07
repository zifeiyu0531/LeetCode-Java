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
        while (p.next.next != null) {
            p = p.next;
            str += p.val + "->";
        }
        str += p.next.val;
        return str;
    }
}

class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("创建链表list");
        LinkedList list = new LinkedList();
        System.out.println("list长度：" + list.size());
        System.out.println("是否为空：" + list.isEmpty());
        System.out.println("向链表添加元素[1,2,3]");
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("输出链表：" + list.toString());
        System.out.println("向链表首部添加元素0");
        list.add(0, 0);
        System.out.println("输出链表：" + list.toString());
        System.out.println("移除表尾元素3");
        list.remove();
        System.out.println("输出链表：" + list.toString());
        System.out.println("移除表头元素0");
        list.remove(0);
        System.out.println("输出链表：" + list.toString());
        System.out.println("list长度：" + list.size());
        System.out.println("是否为空：" + list.isEmpty());
        System.out.println("获取表头元素1：" + list.get(0).val);
    }
}