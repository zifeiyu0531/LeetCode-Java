import java.util.*;
import java.util.LinkedList;

// 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。

// 示例1:

//  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
//  输出：true
// 示例2:

//  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
//  输出 true
// 提示：

// 节点数量n在[0, 1e5]范围内。
// 节点编号大于等于 0 小于 n。
// 图中可能存在自环和平行边。
class Solution_287 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            list.get(graph[i][0]).add(graph[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visitied = new boolean[n];
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            List<Integer> tempList = list.get(curr);
            for (int i = 0; i < tempList.size(); i++) {
                int node = tempList.get(i);
                if (!visitied[node]) {
                    if (node == target) {
                        return true;
                    }
                    visitied[node] = true;
                    queue.offer(node);
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Solution_287 solution = new Solution_287();
        int n_1 = 3, n_2 = 5;
        int[][] graph_1 = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 2 } }, graph_2 = { { 0, 1 }, { 0, 2 }, { 0, 4 },
                { 0, 4 }, { 0, 1 }, { 1, 3 }, { 1, 4 }, { 1, 3 }, { 2, 3 }, { 3, 4 } };
        int start_1 = 0, start_2 = 0;
        int target_1 = 2, target_2 = 4;
        System.out.println(solution.findWhetherExistsPath(n_1, graph_1, start_1, target_1));
        System.out.println(solution.findWhetherExistsPath(n_2, graph_2, start_2, target_2));
    }
}