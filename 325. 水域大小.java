import java.util.*;

// 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。

// 示例：

// 输入：
// [
//   [0,2,1,0],
//   [0,1,0,1],
//   [1,1,0,1],
//   [0,1,0,1]
// ]
// 输出： [1,2,4]
// 提示：

// 0 < len(land) <= 1000
// 0 < len(land[i]) <= 1000
class Solution_325 {
    public int[] pondSizes(int[][] land) {
        Queue<Integer> queue_i = new LinkedList<>();
        Queue<Integer> queue_j = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int m = land.length, n = land[0].length;
        int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] != 0) {
                    continue;
                }
                queue_i.offer(i);
                queue_j.offer(j);
                land[i][j] = -1;
                int size = 0;
                while (!queue_i.isEmpty()) {
                    int temp_i = queue_i.poll();
                    int temp_j = queue_j.poll();
                    size++;
                    for (int idx = 0; idx < 8; idx++) {
                        int x = temp_i + dx[idx];
                        int y = temp_j + dy[idx];
                        if (x >= 0 && x < m && y >= 0 && y < n && land[x][y] == 0) {
                            land[x][y] = -1;
                            queue_i.offer(x);
                            queue_j.offer(y);
                        }
                    }
                }
                res.add(size);
            }
        }
        int[] resArray = res.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(resArray);
        return resArray;
    }

    public static void main(String args[]) {
        Solution_325 solution = new Solution_325();
        int[][] land = {
                { 0, 2, 1, 0 },
                { 0, 1, 0, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 1 }
        };
        System.out.println(Arrays.toString(solution.pondSizes(land)));
    }
}