// 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

// 示例 1:

// 输入: 1->2->3->3->4->4->5
// 输出: 1->2->5
// 示例 2:

// 输入: 1->1->1->2->3
// 输出: 2->3

class Solution_97 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode left = preHead;
        ListNode right = left.next;
        while (left.next != null) {
            if (right.next != null && right.val != right.next.val) {
                left = left.next;
                right = right.next;
            } else if (right.next == null) {
                break;
            } else {
                while (right.next != null && right.val == right.next.val) {
                    right = right.next;
                }
                right = right.next;
                left.next = right;
            }
        }
        return preHead.next;
    }

    public static void main(String args[]) {
    }
}