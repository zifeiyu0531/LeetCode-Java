import java.util.*;

// 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

// 示例:

// 给定的有序链表： [-10, -3, 0, 5, 9],

// 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

//       0
//      / \
//    -3   9
//    /   /
//  -10  5

class Solution_122 {
    public TreeNode sortedListToBST(ListNode head) {
        Integer[] nums = ListToArray(head);
        return getRoot(nums, 0, nums.length - 1);
    }

    public Integer[] ListToArray(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list.toArray(new Integer[list.size()]);
    }

    public TreeNode getRoot(Integer[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = getRoot(nums, start, mid - 1);
        node.right = getRoot(nums, mid + 1, end);
        return node;
    }

    public static void main(String args[]) {
    }
}