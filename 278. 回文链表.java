// 编写一个函数，检查输入的链表是否是回文的。

//  

// 示例 1：

// 输入： 1->2
// 输出： false 
// 示例 2：

// 输入： 1->2->2->1
// 输出： true 
//  

// 进阶：
// 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution_278 {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < len / 2; i++) {
            p = p.next;
        }
        ListNode reverseHead = reverse(p);
        p = head;
        ListNode reverseP = reverseHead;
        for (int i = 0; i < len / 2; i++) {
            if (p.val != reverseP.val) {
                return false;
            }
            p = p.next;
            reverseP = reverseP.next;
        }
        reverseHead = reverse(reverseHead);
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode p = head;
        ListNode temp = null;
        while (p != null) {
            ListNode pre = p.next;
            p.next = temp;
            temp = p;
            p = pre;
        }
        return temp;
    }

    public static void main(String args[]) {
    }
}