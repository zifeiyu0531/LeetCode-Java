// 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

// 注意：本题相对原题稍作改动

// 示例：

// 输入： 1->2->3->4->5 和 k = 2
// 输出： 4
// 说明：

// 给定的 k 保证是有效的。
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution_275 {
    public int kthToLast(ListNode head, int k) {
        ListNode pre = head;
        for (int i = 0; i < k; i++) {
            pre = pre.next;
        }
        ListNode tail = head;
        while (pre != null) {
            pre = pre.next;
            tail = tail.next;
        }
        return tail.val;
    }

    public static void main(String args[]) {
    }
}