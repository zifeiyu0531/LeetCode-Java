package 牛客TOP100;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode p = head;
        ListNode pre = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        return pre;
    }
}