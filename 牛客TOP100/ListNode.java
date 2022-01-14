package 牛客TOP100;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }

    public String toString() {
        String s = "";
        ListNode node = this;
        while (node != null) {
            s += node.val;
            if (node.next != null) {
                s += "->";
            }
            node = node.next;
        }
        return s;
    }

    public static ListNode buildList(int[] nums) {
        ListNode header = new ListNode();
        ListNode p = new ListNode();
        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            if (i == 0) {
                header = node;
                p = header;
            } else {
                p.next = node;
                p = p.next;
            }
        }
        return header;
    }
}