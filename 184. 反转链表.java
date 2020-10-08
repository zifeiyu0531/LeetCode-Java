// 反转一个单链表。

// 示例:

// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
// 进阶:
// 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class Solution_184 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode p1 = null;
        ListNode p2 = head;

        while (p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }

    public static void main(String args[]) {

    }
}