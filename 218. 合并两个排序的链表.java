// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

// 示例1：

// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4
// 限制：

// 0 <= 链表长度 <= 1000

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
class Solution_218 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                break;
            }
            if (l2 == null) {
                p.next = l1;
                break;
            }
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        return preHead.next;
    }

    public static void main(String args[]) {
    }
}