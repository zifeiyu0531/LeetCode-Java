// 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

// 你不需要 保留 每个分区中各节点的初始相对位置。

//  

// 示例 1：

// 输入：head = [1,4,3,2,5,2], x = 3
// 输出：[1,2,2,4,3,5]
// 示例 2：

// 输入：head = [2,1], x = 2
// 输出：[1,2]
//  

// 提示：

// 链表中节点的数目在范围 [0, 200] 内
// -100 <= Node.val <= 100
// -200 <= x <= 200
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution_276 {
    public ListNode partition(ListNode head, int x) {
        ListNode pre1 = new ListNode(), pre2 = new ListNode();
        ListNode p1 = pre1, p2 = pre2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            p = p.next;
        }
        p2.next = null;
        p1.next = pre2.next;
        return pre1.next;
    }

    public static void main(String args[]) {
    }
}