// 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

// 示例 1:

// 输入: 1->2->3->4->5->NULL, k = 2
// 输出: 4->5->1->2->3->NULL
// 解释:
// 向右旋转 1 步: 5->1->2->3->4->NULL
// 向右旋转 2 步: 4->5->1->2->3->NULL
// 示例 2:

// 输入: 0->1->2->NULL, k = 4
// 输出: 2->0->1->NULL
// 解释:
// 向右旋转 1 步: 2->0->1->NULL
// 向右旋转 2 步: 1->2->0->NULL
// 向右旋转 3 步: 0->1->2->NULL
// 向右旋转 4 步: 2->0->1->NULL

class Solution_80 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode p = preHead;
        int len = 0;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        if (len <= 1) {
            return head;
        }
        k %= len;
        p.next = head;
        int time = len - k;
        while (time > 0) {
            p = p.next;
            time--;
        }
        ListNode ans = p.next;
        p.next = null;
        return ans;
    }

    public static void main(String args[]) {
    }
}