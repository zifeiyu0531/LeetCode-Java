import java.util.*;

// 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回锯齿形层次遍历如下：

// [
//   [3],
//   [20,9],
//   [15,7]
// ]

class Solution_115 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        if (root != null) {
            dq.addLast(root);
        }
        boolean isReverse = false;
        while (!dq.isEmpty()) {
            int levelSize = dq.size();
            List<Integer> nums = new ArrayList<Integer>();
            for (int i = 0; i < levelSize; i++) {
                if (!isReverse) {
                    TreeNode node = dq.pollFirst();
                    nums.add(node.val);
                    if (node.left != null) {
                        dq.addLast(node.left);
                    }
                    if (node.right != null) {
                        dq.addLast(node.right);
                    }
                } else {
                    TreeNode node = dq.pollLast();
                    nums.add(node.val);
                    if (node.right != null) {
                        dq.addFirst(node.right);
                    }
                    if (node.left != null) {
                        dq.addFirst(node.left);
                    }
                }
            }
            isReverse = !isReverse;
            ans.add(nums);
        }
        return ans;
    }

    public static void main(String args[]) {
    }
}