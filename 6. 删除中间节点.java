// 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。

//  

// 示例：

// 输入：单向链表a->b->c->d->e->f中的节点c
// 结果：不返回任何数据，但该链表变为a->b->d->e->f

class Solution_6 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String args[]) {
        Solution_6 solution = new Solution_6();
        int[] nums = { 4, 5, 1, 9 };
        ListNode header = ListNode.buildList(nums);
        ListNode node = header.next;
        solution.deleteNode(node);
        System.out.println(header.toString());
    }
}