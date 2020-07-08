class Solution_2 {
    public void UnionList(LinkedNode LA, LinkedNode LB) {
        LinkedNode p1 = LA.next, p2 = LB.next;
        LinkedNode index = LA;
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
    }
}