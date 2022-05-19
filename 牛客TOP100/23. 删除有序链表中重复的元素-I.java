package 牛客TOP100;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

class Solution {
    /**
     * 
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head, right = head;
        while (right != null) {
            right = right.next;
            while (right != null && left.val == right.val) {
                right = right.next;
            }
            left.next = right;
            left = right;
        }
        return head;
    }
}