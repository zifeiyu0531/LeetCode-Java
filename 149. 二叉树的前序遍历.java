import java.util.*;

// 给定一个二叉树，返回它的 前序 遍历。

//  示例:

// 输入: [1,null,2,3]  
//    1
//     \
//      2
//     /
//    3 

// 输出: [1,2,3]
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？

class Solution_149 {
    List<Integer> ans;

    public List<Integer> preorderTraversal(TreeNode root) {
        ans = new ArrayList<Integer>();
        getNode(root);
        return ans;
    }

    public void getNode(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        getNode(root.left);
        getNode(root.right);
    }

    public static void main(String args[]) {
    }
}