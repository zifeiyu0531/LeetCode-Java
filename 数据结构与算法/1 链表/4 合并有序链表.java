class Solution_2 {
    /**
     * 合并有序链表
     * 
     * @param LA 有序链表头节点
     * @param LB 有序链表头节点
     * @return 合并后的链表头节点
     */
    public LinkedNode<Integer> UnionList(LinkedNode<Integer> LA, LinkedNode<Integer> LB) {
        LinkedNode<Integer> p1 = LA, p2 = LB;
        LinkedNode<Integer> preHead = new LinkedNode<Integer>(-1);
        LinkedNode<Integer> index = preHead;
        while (p1 != null || p2 != null) {
            if (p1 == null) {
                index.next = p2;
                break;
            } else if (p2 == null) {
                index.next = p1;
                break;
            } else {
                if (p1.val < p2.val) {
                    index.next = p1;
                    p1 = p1.next;
                } else {
                    index.next = p2;
                    p2 = p2.next;
                }
            }
            index = index.next;
        }
        return preHead.next;
    }
}