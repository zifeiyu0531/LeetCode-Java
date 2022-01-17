package 牛客TOP100;

import java.util.*;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 * }
 */

class Solution {
    /**
     * 
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> tempQ = new LinkedList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) {
                    tempQ.offer(node.left);
                }
                if (node.right != null) {
                    tempQ.offer(node.right);
                }
            }
            res.add(temp);
            queue = tempQ;
        }
        return res;
    }
}