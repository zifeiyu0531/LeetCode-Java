// 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

// 请你返回该链表所表示数字的 十进制值 。

//  

// 示例 1：

// 输入：head = [1,0,1]
// 输出：5
// 解释：二进制数 (101) 转化为十进制数 (5)
// 示例 2：

// 输入：head = [0]
// 输出：0
// 示例 3：

// 输入：head = [1]
// 输出：1
// 示例 4：

// 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
// 输出：18880
// 示例 5：

// 输入：head = [0,0]
// 输出：0
//  

// 提示：

// 链表不为空。
// 链表的结点总数不超过 30。
// 每个结点的值不是 0 就是 1。

class Solution_20 {
    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        int ans = 0;
        while (p != null) {
            ans = (ans << 1) + p.val;
            p = p.next;
        }
        return ans;
    }

    public static void main(String args[]) {
        Solution_20 solution = new Solution_20();
        int[] nums_1 = { 1, 0, 1 }, nums_2 = { 0 }, nums_3 = { 1 },
                nums_4 = { 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 }, nums_5 = { 0, 0 };
        ListNode header = ListNode.buildList(nums_1);
        System.out.println(solution.getDecimalValue(header));
        header = ListNode.buildList(nums_2);
        System.out.println(solution.getDecimalValue(header));
        header = ListNode.buildList(nums_3);
        System.out.println(solution.getDecimalValue(header));
        header = ListNode.buildList(nums_4);
        System.out.println(solution.getDecimalValue(header));
        header = ListNode.buildList(nums_5);
        System.out.println(solution.getDecimalValue(header));
    }
}