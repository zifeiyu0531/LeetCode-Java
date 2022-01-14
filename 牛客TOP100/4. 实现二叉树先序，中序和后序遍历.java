package 牛客TOP100;

import java.util.*;

class Solution {
    private List<Integer> preOrder = new ArrayList<>();
    private List<Integer> midOrder = new ArrayList<>();
    private List<Integer> postOrder = new ArrayList<>();

    /**
     * 
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        preOrder(root);
        midOrder(root);
        postOrder(root);
        int[][] res = new int[3][];
        res[0] = ListToArray(preOrder);
        res[1] = ListToArray(midOrder);
        res[2] = ListToArray(postOrder);
        return res;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    private void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        midOrder.add(root.val);
        midOrder(root.right);
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        postOrder.add(root.val);
    }

    private int[] ListToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}