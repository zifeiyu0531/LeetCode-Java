// 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

// 示例 1:

// 输入: 4->2->1->3
// 输出: 1->2->3->4
// 示例 2:

// 输入: -1->5->3->4->0
// 输出: -1->0->3->4->5

class Solution_154 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode p = preHead, q = head.next;
        head.next = null;
        while (q != null) {
            ListNode temp = q.next;
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

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode p = preHead, q = head.next;
        head.next = null;
        while (q != null) {
            ListNode temp = q.next;
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

    public static void main(String args[]) {
    }
}