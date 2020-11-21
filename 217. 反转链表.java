// 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

//  

// 示例:

// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
//  

// 限制：

// 0 <= 节点个数 <= 5000

// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode(int x) { val = x; }
//  * }
//  */
class Solution_217 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = null, p1 = head, p2 = head.next;
        while (p2 != null) {
            p1.next = temp;
            temp = p1;
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = temp;
        return p1;
    }

    public static void main(String args[]) {
    }
}