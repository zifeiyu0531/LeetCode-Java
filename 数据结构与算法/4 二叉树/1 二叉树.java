import java.util.*;

// 二叉树节点BTNode
class BTNode<T> {
    T val;
    BTNode<T> left;
    BTNode<T> right;

    public BTNode() {
        this(null);
    }

    public BTNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// 二叉树基本运算
class MyBTree {
    BTNode<Character> root;

    public MyBTree() {
        root = null;
    }

    // 返回根节点
    public BTNode<Character> getRoot() {
        return this.root;
    }

    // 根据规范字符串建立二叉树
    public void CreatTree(String str) {
        Stack<BTNode<Character>> stack = new Stack<BTNode<Character>>();
        BTNode<Character> p = null;
        boolean isLeft = true;
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(p);
                    isLeft = true;
                    break;
                case ')':
                    stack.pop();
                    break;
                case ',':
                    isLeft = false;
                    break;
                default:
                    p = new BTNode<Character>(ch);
                    if (root == null) {
                        root = p;
                    } else {
                        if (isLeft) {
                            stack.peek().left = p;
                        } else {
                            stack.peek().right = p;
                        }
                    }
            }
        }
    }

    // 根据给定val值找到对应节点并返回
    public BTNode<Character> getNode(BTNode<Character> root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else {
            BTNode<Character> p = getNode(root.left, val);
            if (p != null) {
                return p;
            } else {
                return getNode(root.right, val);
            }
        }
    }

    // 获取二叉树最大深度
    public int getDepth(BTNode<Character> root) {
        return root == null ? 0 : Math.max(getDepth(root.left) + 1, getDepth(root.right) + 1);
    }

    // 格式化输出二叉树
    public String toString(BTNode<Character> root) {
        String str = "";
        if (root != null) {
            str += root.val;
            if (root.left != null || root.right != null) {
                str += "(";
                str += toString(root.left);
                if (root.right != null) {
                    str += ",";
                }
                str += toString(root.right);
                str += ")";
            }
        }
        return str;
    }
}