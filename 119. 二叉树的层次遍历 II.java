import java.util.*;

// 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

// 例如：
// 给定二叉树 [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回其自底向上的层次遍历为：

// [
//   [15,7],
//   [9,20],
//   [3]
// ]

class Solution_119 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<List<Integer>> ans = new ArrayDeque<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> nums = new ArrayList<Integer>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                nums.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.addFirst(nums);
        }
        return new ArrayList<List<Integer>>(ans);
    }

    public static void main(String args[]) {
    }
}