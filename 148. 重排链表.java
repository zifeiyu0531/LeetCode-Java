// 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
// 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

// 示例 1:

// 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
// 示例 2:

// 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.

class Solution_148 {
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        ListNode mid = head, right = head;
        while (right != null && right.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        ListNode midHead = reverseList(mid.next);
        mid.next = null;
        while (midHead != null) {
            ListNode temp1 = head.next;
            ListNode temp2 = midHead.next;
            head.next = midHead;
            midHead.next = temp1;
            head = temp1;
            midHead = temp2;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = null;
        ListNode temp = head.next;
        while (temp != null) {
            head.next = p;
            p = head;
            head = temp;
            temp = temp.next;
        }
        head.next = p;
        return head;
    }

    public static void main(String args[]) {
    }
}