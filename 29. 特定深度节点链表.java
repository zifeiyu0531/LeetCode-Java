import java.util.*;

// 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。

//  

// 示例：

// 输入：[1,2,3,4,5,null,7,8]

//         1
//        /  \ 
//       2    3
//      / \    \ 
//     4   5    7
//    /
//   8

// 输出：[[1],[2,3],[4,5,7],[8]]

class Solution_29 {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ListNode> node_list = new ArrayList<ListNode>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode header = new ListNode(-1);
            ListNode p = header;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                p.next = new ListNode(current.val);
                p = p.next;
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            node_list.add(header.next);
        }
        return (ListNode[]) node_list.toArray(new ListNode[0]);
    }

    public static void main(String args[]) {
    }
}