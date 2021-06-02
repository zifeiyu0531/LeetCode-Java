// 给定一棵二叉搜索树，请找出其中第k大的节点。

//  

// 示例 1:

// 输入: root = [3,1,4,null,2], k = 1
//    3
//   / \
//  1   4
//   \
//    2
// 输出: 4
// 示例 2:

// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//        5
//       / \
//      3   6
//     / \
//    2   4
//   /
//  1
// 输出: 4
//  

// 限制：

// 1 ≤ k ≤ 二叉搜索树元素个数
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution_230 {
    private int target;
    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        mid_order(root);
        return target;
    }

    private void mid_order(TreeNode root) {
        if (root == null) {
            return;
        }
        mid_order(root.right);
        if (k == 0) {
            return;
        }
        if (k-- == 1) {
            target = root.val;
        }
        mid_order(root.left);
    }

    public static void main(String args[]) {
    }
}