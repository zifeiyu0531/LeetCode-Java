class Solution_1 {
    /**
     * 链表排序
     * 
     * @param head 待排序链表头节点
     * @return 排序后链表头节点
     */
    public LinkedNode<Integer> sort(LinkedNode<Integer> head) {
        if (head == null) {
            return null;
        }
        LinkedNode<Integer> preHead = new LinkedNode<Integer>(-1);
        preHead.next = head;
        LinkedNode<Integer> p = preHead, q = head.next;
        head.next = null;
        while (q != null) {
            LinkedNode<Integer> temp = q.next;
            p = preHead;
            while (p.next != null && p.next.val <= q.val) {
                p = p.next;
            }
            q.next = p.next;
            p.next = q;
            q = temp;
        }
        return preHead.next;
    }
}