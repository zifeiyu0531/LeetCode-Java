import java.util.*;

// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

//  

// 例如:
// 给定二叉树: [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回其层次遍历结果：

// [
//   [3],
//   [9,20],
//   [15,7]
// ]
//  

// 提示：

// 节点总数 <= 1000
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution_245 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
            List<Integer> tempR = new ArrayList<Integer>();
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    tempQ.offer(node.left);
                }
                if (node.right != null) {
                    tempQ.offer(node.right);
                }
                tempR.add(node.val);
            }
            q = tempQ;
            res.add(tempR);
        }
        return res;
    }

    public static void main(String args[]) {
    }
}