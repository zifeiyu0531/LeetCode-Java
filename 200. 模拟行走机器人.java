// 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：

// -2：向左转 90 度
// -1：向右转 90 度
// 1 <= x <= 9：向前移动 x 个单位长度
// 在网格上有一些格子被视为障碍物。

// 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])

// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。

// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。

//  

// 示例 1：

// 输入: commands = [4,-1,3], obstacles = []
// 输出: 25
// 解释: 机器人将会到达 (3, 4)
// 示例 2：

// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
// 输出: 65
// 解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
//  

// 提示：

// 0 <= commands.length <= 10000
// 0 <= obstacles.length <= 10000
// -30000 <= obstacle[i][0] <= 30000
// -30000 <= obstacle[i][1] <= 30000
// 答案保证小于 2 ^ 31

class Solution_200 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] pos = { 0, 0 };
        int dir = 0;
        int max = 0;
        for (int c : commands) {
            Boolean change = false;
            switch (c) {
                case -1:
                    dir = (dir + 1) % 4;
                    break;
                case -2:
                    dir = (dir + 3) % 4;
                    break;
                default:
                    switch (dir) {
                        case 0:
                            for (int[] o : obstacles) {
                                if (pos[0] == o[0] && pos[1] < o[1] && pos[1] + c >= o[1]) {
                                    pos[1] = o[1] - 1;
                                    change = true;
                                    break;
                                }
                            }
                            if (!change) {
                                pos[1] += c;
                                change = false;
                            }
                            break;
                        case 1:
                            for (int[] o : obstacles) {
                                if (pos[1] == o[1] && pos[0] < o[0] && pos[0] + c >= o[0]) {
                                    pos[0] = o[0] - 1;
                                    change = true;
                                    break;
                                }
                            }
                            if (!change) {
                                pos[0] += c;
                                change = false;
                            }
                            break;
                        case 2:
                            for (int[] o : obstacles) {
                                if (pos[0] == o[0] && pos[1] > o[1] && pos[1] - c <= o[1]) {
                                    pos[1] = o[1] + 1;
                                    change = true;
                                    break;
                                }
                            }
                            if (!change) {
                                pos[1] -= c;
                                change = false;
                            }
                            break;
                        case 3:
                            for (int[] o : obstacles) {
                                if (pos[1] == o[1] && pos[0] > o[0] && pos[0] - c <= o[0]) {
                                    pos[0] = o[0] + 1;
                                    change = true;
                                    break;
                                }
                            }
                            if (!change) {
                                pos[0] -= c;
                                change = false;
                            }
                            break;
                    }
                    max = Math.max(max, (int) Math.pow(pos[0], 2) + (int) Math.pow(pos[1], 2));
            }
        }
        return max;
    }

    public static void main(String args[]) {
        Solution_200 solution = new Solution_200();
        int[] commands_1 = { 4, -1, 3 }, commands_2 = { 4, -1, 4, -2, 4 };
        int[][] obstacles_1 = {}, obstacles_2 = { { 2, 4 } };
        System.out.println(solution.robotSim(commands_1, obstacles_1));
        System.out.println(solution.robotSim(commands_2, obstacles_2));
    }
}