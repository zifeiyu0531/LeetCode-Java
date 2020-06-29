// 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

// 说明:
// 1 ≤ m ≤ n ≤ 链表长度。

// 示例:

// 输入: 1->2->3->4->5->NULL, m = 2, n = 4
// 输出: 1->4->3->2->5->NULL

class Solution_105 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead, p1 = head, p2 = head;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            p1 = p1.next;
        }
        for (int i = 1; i <= n; i++) {
            p2 = p2.next;
        }
        for (int i = 0; i <= n - m; i++) {
            ListNode temp = p1.next;
            p1.next = p2;
            p2 = p1;
            p1 = temp;
        }
        pre.next = p2;
        return preHead.next;
    }

    public static void main(String args[]) {
    }
}