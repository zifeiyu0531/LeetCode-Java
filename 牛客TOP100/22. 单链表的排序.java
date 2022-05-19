package 牛客TOP100;

import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

class Solution {
    /**
     * 
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((m, n) -> n.val - m.val);
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode pre = new ListNode(0), temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            temp.next = pre.next;
            pre.next = temp;
        }
        return pre.next;
    }
}