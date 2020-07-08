class ListSort {
    public void sort(LinkedNode head) {
        if (head.next == null) {
            return;
        }
        LinkedNode p = head.next.next;
        head.next.next = null;
        while (p != null) {
            LinkedNode q = p.next;
            LinkedNode pre = head;
            while (pre.next != null && pre.next.val <= p.val) {
                pre = pre.next;
            }
            p.next = pre.next;
            pre.next = p;
            p = q;
        }
    }
}