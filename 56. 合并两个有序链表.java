// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

//  

// 示例：

// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4

class Solution_56 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while(l1!= null && l2 != null){
            if(l1.val <= l2.val){
                prev.next = l1;
                l1 = l1.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if(l1 != null){
            prev.next = l1;
        }else{
            prev.next = l2;
        }
        return preHead.next;
    }

    public static void main(String args[]) {
    }
}