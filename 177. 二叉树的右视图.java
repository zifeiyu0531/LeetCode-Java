import java.util.*;

// 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

// 示例:

// 输入: [1,2,3,null,5,null,4]
// 输出: [1, 3, 4]
// 解释:

//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution_177 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return getList(list, root);
    }

    public List<Integer> getList(List<Integer> list, TreeNode node) {
        if (node == null) {
            return list;
        }
        list.add(node.val);
        List<Integer> right = getList(new ArrayList<Integer>(list), node.right);
        List<Integer> left = getList(new ArrayList<Integer>(list), node.left);
        if (left.size() > right.size()) {
            for (int i = right.size(); i < left.size(); i++) {
                right.add(left.get(i));
            }
        }
        return right;
    }
}