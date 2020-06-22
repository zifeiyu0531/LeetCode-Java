// 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

// 示例：

// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
// 输出：7 -> 0 -> 8
// 原因：342 + 465 = 807

class Solution_32 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        ListNode p1 = l1, p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int num_1 = (p1 == null) ? 0 : p1.val;
            int num_2 = (p2 == null) ? 0 : p2.val;
            int sum = carry + num_1 + num_2;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }
        return head.next;
    }

    public static void main(String args[]) {
    }
}